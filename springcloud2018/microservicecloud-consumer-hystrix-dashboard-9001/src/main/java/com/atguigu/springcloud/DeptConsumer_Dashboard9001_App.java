package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/10/21 11:42
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_Dashboard9001_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_Dashboard9001_App.class,args);
    }
}
