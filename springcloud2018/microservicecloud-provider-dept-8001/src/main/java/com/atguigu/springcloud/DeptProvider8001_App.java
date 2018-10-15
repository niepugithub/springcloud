package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/10/15 22:46
 **/
@SpringBootApplication
public class DeptProvider8001_App {//类名加上端口号，方便区分
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_App.class,args);
    }
}
