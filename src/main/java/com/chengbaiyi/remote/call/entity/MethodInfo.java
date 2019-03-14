package com.chengbaiyi.remote.call.entity;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.util.Map;

/**
 * @author xudongsheng
 * @title: MethodInfo
 * @projectName remotecall
 * @description: TODO
 * @date 2019/3/12 11:36
 */
public class MethodInfo {

    /**
     *  uri
     */
    private String uri;

    /**
     *  请求方式
     */
    private HttpMethod httpMethod;

    /**
     *  参数类型
     */
    private Class<?> paramType;

    /**
     *  参数
     */
    private Object params;

    /**
     *  请求Content-Type
     */
    private MediaType mediaType;

    /**
     *  路径上的请求参数
     */
    private Map<String, Object> pathVariable;

    /**
     *  该方法的返回值
     */
    private Class<?> returnType;

    /**
     *  是否是Flux类型
     */
    private boolean whetherFlux;


    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Class<?> getParamType() {
        return paramType;
    }

    public void setParamType(Class<?> paramType) {
        this.paramType = paramType;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public Map<String, Object> getPathVariable() {
        return pathVariable;
    }

    public void setPathVariable(Map<String, Object> pathVariable) {
        this.pathVariable = pathVariable;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Class<?> getReturnType() {
        return returnType;
    }

    public void setReturnType(Class<?> returnType) {
        this.returnType = returnType;
    }

    public boolean isWhetherFlux() {
        return whetherFlux;
    }

    public void setWhetherFlux(boolean whetherFlux) {
        this.whetherFlux = whetherFlux;
    }
}
