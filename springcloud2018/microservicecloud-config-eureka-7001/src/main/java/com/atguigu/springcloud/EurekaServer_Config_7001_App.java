package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/10/16 21:16
 **/
@SpringBootApplication
@EnableEurekaServer // 不能忘记
public class EurekaServer_Config_7001_App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_Config_7001_App.class,args);
    }
}
