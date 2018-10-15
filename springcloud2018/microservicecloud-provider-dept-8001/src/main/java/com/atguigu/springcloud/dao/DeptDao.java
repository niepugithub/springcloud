package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/10/15 22:17
 **/
@Mapper
public interface DeptDao {
    boolean addDept(Dept dept);
    Dept findById(Long id);
    List<Dept> findAll();
}

