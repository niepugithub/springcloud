package com.atguigu.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/10/21 17:27
 **/
@RestController
public class ConfigClientRest {
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig(){
        String str="applicationName:"+applicationName+", eurekaServers:"+eurekaServers+", port:"+port;
        System.out.println("str==="+str);
        return str;
    }
}
