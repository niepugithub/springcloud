package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;

import java.util.List;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/10/15 22:23
 **/
public interface DeptService {
    // list,get命名方式更加符合rest风格
    boolean add(Dept dept);
    Dept get(Long id);
    List<Dept> list();
}
