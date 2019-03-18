package com.chengbaiyi.remote.call.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @title: ApiServerCondition
 * @projectName: remotecall
 * @description: TODO
 * @author: xudongsheng
 * @date: 2019/3/15 17:15
 */
public class ApiServerCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {


        return true;
    }
}
