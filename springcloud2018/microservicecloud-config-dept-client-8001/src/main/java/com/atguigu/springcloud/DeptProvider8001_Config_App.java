package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/10/15 22:46
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient // 添加此注解，方便从eureka注册中心找到其他客户端
public class DeptProvider8001_Config_App {//类名加上端口号，方便区分
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_Config_App.class,args);
    }
}
