package com.chengbaiyi.remote.call.config;


import com.chengbaiyi.remote.call.interf.ProxyCreator;
import com.chengbaiyi.remote.call.proxy.JdkProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title: ProxyProperties
 * @projectName: remotecall
 * @description: TODO
 * @author: xudongsheng
 * @date: 2019/3/15 17:02
 */
@Configuration
@ConditionalOnClass
@EnableConfigurationProperties(ProxyProperties.class)
@ConditionalOnProperty(prefix = "baiyi",value = "enabled", matchIfMissing = true)
public class ProxyConfig {

    @Autowired
    private ProxyProperties proxyProperties;

    @Bean
    public ProxyCreator jdkProxyCreator(){
        if (proxyProperties.getProxyCreator().equals("jdk-proxy")){
            return new JdkProxyCreator();
        }
        return new JdkProxyCreator();
    }
}
