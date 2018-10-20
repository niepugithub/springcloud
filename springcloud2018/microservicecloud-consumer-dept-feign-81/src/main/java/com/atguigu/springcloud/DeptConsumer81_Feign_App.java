package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/10/16 0:19
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.atguigu.springcloud")
@ComponentScan("com.atguigu.springcloud")
public class DeptConsumer81_Feign_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer81_Feign_App.class,args);
    }
}
