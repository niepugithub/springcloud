package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:根据已有的DeptClientService
 * 接口新建一个实现了FallbackFactory接口的类
 * DeptClientServiceFallbackFactory
 * 实现统一的短路保护；之前是一个接口方法一个fallback短路保护方法
 * 麻烦。借用spring aop思想
 * 将DeptClientService中所有方法的fallback方法集中处理
 * @author:niepu
 * @version:1.0
 * @date:2018/10/20 20:54
 **/
@Component  // 不要忘记
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {

        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept(id,"该id没有对应部门","统一处理");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
