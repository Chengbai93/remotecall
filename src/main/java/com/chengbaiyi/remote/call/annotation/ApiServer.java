package com.chengbaiyi.remote.call.annotation;


import com.chengbaiyi.remote.call.config.ApiServerCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Conditional(ApiServerCondition.class)
public @interface ApiServer {

    String domain() default "";
}
