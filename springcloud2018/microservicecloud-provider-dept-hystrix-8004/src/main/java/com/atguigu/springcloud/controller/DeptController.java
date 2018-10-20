package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/10/15 22:23
 **/
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/dept/add")
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }
    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrixGet")
    public Dept get(@PathVariable("id") Long id){
        Dept dept=deptService.get(id);
        if(dept==null){
            throw new RuntimeException("该id："+id+"没有对应的信息");
        }
        return dept;
    }

    public Dept processHystrixGet(@PathVariable("id") Long id){
        return new Dept(id,"该id没有对应部门","no source");
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return deptService.list();
    }

    // eureka服务发现
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> services=client.getServices();
        System.out.println("========="+services);

        List<ServiceInstance> srvList=client.getInstances("MICROSERVICECLOUD-DEPT");
        for(ServiceInstance instance:srvList ){
            System.out.println(instance.getHost()+"; "+instance.getServiceId()+"; "
            +instance.getUri());
        }
        return this.client;
    }
}
