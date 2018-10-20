package com.atguigu.springcloud.cfgbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
}
