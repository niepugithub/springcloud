package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/10/14 22:02
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)// 开启链式处理
public class Dept implements Serializable{ // Entity

    //不让系统自动生成，自己写一个序列化版本号
    private static final long serialVersionUID = 1L;

    // 如果自己生成setget和构造器，非常麻烦，尤其是增加或者删除属性的时候，使用lombok
    private Long deptno;// 主键
    private String dname;// 部门名称
    // 来自哪个数据库，因为微服务架构可以一个服务对应一个数据，同一个信息被存储到不同数据库
    private String db_source;

    public static void main(String[] args) {
        Dept dept=new Dept(1L,"财务部","DB01");
        Dept d=new Dept();
        // 链式处理案例
        d.setDname("开发部").setDb_source("DB01");
        System.out.println(d.getDname());
    }

}
