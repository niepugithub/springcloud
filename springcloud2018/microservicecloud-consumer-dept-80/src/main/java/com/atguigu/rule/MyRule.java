package com.atguigu.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/10/20 15:46
 **/
@Configuration
public class MyRule {
    @Bean
    public IRule myRoundRobinRule(){
        return new RoundRobinRule();
    }
}
