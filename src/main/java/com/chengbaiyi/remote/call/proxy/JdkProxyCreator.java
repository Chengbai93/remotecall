package com.chengbaiyi.remote.call.proxy;

import com.chengbaiyi.remote.call.annotation.ApiServer;
import com.chengbaiyi.remote.call.entity.MethodInfo;
import com.chengbaiyi.remote.call.interf.ProxyCreator;
import com.chengbaiyi.remote.call.interf.RestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author xudongsheng
 * @title: JdkProxyCreator
 * @projectName remotecall
 * @description: TODO
 * @date 2019/3/12 11:30
 */
public class JdkProxyCreator implements ProxyCreator {


    @Autowired
    RestHandler restHandler;

    @Override
    public Object createProxy(Class<?> type) {
        ApiServer annotation = type.getAnnotation(ApiServer.class);
        restHandler.initRestHandler(annotation);
        return Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                MethodInfo methodInfo = abstractMethodInfo(method);
                methodInfo = abstractParams(method,args,methodInfo);
                return restHandler.handlerRequest(methodInfo);
            }

            private MethodInfo abstractParams(Method method, Object[] args, MethodInfo methodInfo) {
                Parameter[] parameters = method.getParameters();
                Map<String,Object> map = new HashMap<>();
                for (int i = 0; i < parameters.length; i++){
                    PathVariable annotation1 = parameters[i].getAnnotation(PathVariable.class);
                    if (annotation1 != null){
                        map.put(annotation1.value(),args[i]);
                    }
                    RequestBody annotation2 = parameters[i].getAnnotation(RequestBody.class);
                    if (annotation2 != null){
                        Class<?> aClass = args[i].getClass();
                        methodInfo.setParams(args[i]);
                        methodInfo.setParamType(aClass);
                        methodInfo.setMediaType(MediaType.APPLICATION_JSON_UTF8);
                    }
                    RequestParam annotation3 = parameters[i].getAnnotation(RequestParam.class);
                    if (annotation3 != null){
                        Class<?> aClass = args[i].getClass();
                        methodInfo.setParams(args[i]);
                        methodInfo.setParamType(aClass);
                    }
                }
                methodInfo.setPathVariable(map);
                return methodInfo;
            }


            private MethodInfo abstractMethodInfo(Method method) {
                Annotation[] annotations = method.getAnnotations();
                MethodInfo methodInfo = new MethodInfo();
                boolean isFlux = method.getReturnType().isAssignableFrom(Flux.class);
                methodInfo.setWhetherFlux(isFlux);
                Type[] actualTypeArguments = ((ParameterizedType) method.getGenericReturnType()).getActualTypeArguments();
                methodInfo.setReturnType((Class<?>) actualTypeArguments[0]);
                Stream.of(annotations).forEach(annotation1 -> {
                    if (annotation1 instanceof GetMapping){
                        methodInfo.setHttpMethod(HttpMethod.GET);
                    } else if (annotation1 instanceof PostMapping){
                        methodInfo.setHttpMethod(HttpMethod.POST);
                    } else if (annotation1 instanceof DeleteMapping){
                        methodInfo.setHttpMethod(HttpMethod.DELETE);
                    } else if (annotation1 instanceof PutMapping){
                        methodInfo.setHttpMethod(HttpMethod.PUT);
                    }
                });

                return methodInfo;
            }
        });
    }
}
