package com.atguigu.springcloud.cfgbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/10/15 23:43
 **/
@Configuration
public class ConfigBean {
    // boot applicationContext.xml ---@Configuration配置  configBean=applicationContext.xml
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
