package com.chengbaiyi.remote.call.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @title: ApiServerCofig
 * @projectName: remotecall
 * @description: TODO
 * @author: xudongsheng
 * @date: 2019/3/19 10:36
 */
@Component
@Aspect
public class ApiServerCofig {

    @Pointcut("@annotation(com.chengbaiyi.remote.call.annotation.ApiServer)")
    private void apiServer(){};

    @Around("apiServer()")
    public Object interceptor(ProceedingJoinPoint proceedingJoinPoint){
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        // 获取参数内容
        Object[] args = proceedingJoinPoint.getArgs();
        // 获取参数对象
        Parameter[] parameters = method.getParameters();
        return null;
    }
}
