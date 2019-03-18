package com.chengbaiyi.remote.call.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @title: RequestSetProperties
 * @projectName: remotecall
 * @description: TODO
 * @author: xudongsheng
 * @date: 2019/3/15 15:14
 */
@ConfigurationProperties(prefix = "chengbaiyi")
public class RestHandlerProperties {

    private static final String REST_HANDLER = "webclient";


    private String restHandler = REST_HANDLER;

    public String getRestHandler() {
        return restHandler;
    }

    public void setRestHandler(String restHandler) {
        this.restHandler = restHandler;
    }
}
