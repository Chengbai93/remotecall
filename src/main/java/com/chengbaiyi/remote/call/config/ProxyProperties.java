package com.chengbaiyi.remote.call.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @title: ProxyProperties
 * @projectName: remotecall
 * @description: TODO
 * @author: xudongsheng
 * @date: 2019/3/18 15:37
 */
@ConfigurationProperties(prefix = "chengbaiyi.proxy")
public class ProxyProperties {

    private static final String PROXY_CREATOR = "jdk-proxy";

    private String proxyCreator = PROXY_CREATOR;

    public String getProxyCreator() {
        return proxyCreator;
    }

    public void setProxyCreator(String proxyCreator) {
        this.proxyCreator = proxyCreator;
    }
}
