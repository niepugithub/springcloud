package com.atguigu.springcloud.cfgbean;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/10/15 23:43
 **/
@Configuration
public class ConfigBean {
    // boot applicationContext.xml ---@Configuration配置  configBean=applicationContext.xml
    // RestTemplate提供很多便捷访问远程HTTP服务的方法
    // 是一种简洁的访问restful服务模板类，spring提供的访问rest服务的客户端
    @Bean
    @LoadBalanced // springcloud基于netflix ribbon实现一套基于客户端的负载均衡工具
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    // FeignClientsConfiguration中可以看到，没有Feign.Builder，yml便没有feign.clent.enabled属性
//    @Bean
//    @Scope("prototype")
//    public Feign.Builder feignHystrixBuilder() {
//        return Feign.builder();
//    }

    // 添加其他负载均衡算法；默认是轮询，RoundRobinRule
    // 使用自定义的AbstractLoadBalancerRule，下面的这个注释掉
//    @Bean
//    public IRule myRule(){
//        return new RandomRule();
//    }
}
