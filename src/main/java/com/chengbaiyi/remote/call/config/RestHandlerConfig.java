package com.chengbaiyi.remote.call.config;

import com.chengbaiyi.remote.call.handler.WebClientHandler;
import com.chengbaiyi.remote.call.interf.RestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @title: RestHandlerConfig
 * @projectName: remotecall
 * @description: TODO
 * @author: xudongsheng
 * @date: 2019/3/15 15:19
 */
@Configuration
@EnableConfigurationProperties(RestHandlerProperties.class)
@ConditionalOnClass()
@ComponentScan
@ConditionalOnProperty(prefix = "baiyi",value = "enabled", matchIfMissing = true)
public class RestHandlerConfig {

    @Autowired
    private RestHandlerProperties restHandlerProperties;

    @Bean
    public RestHandler restHandler(){
        if ("httpclient".equals(restHandlerProperties.getRestHandler())){
            System.out.println("实例化httpclient");
            return null;
        }

        return new WebClientHandler();
    }
}
