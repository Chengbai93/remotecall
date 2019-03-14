package com.chengbaiyi.remote.call.handler;

import com.chengbaiyi.remote.call.annotation.ApiServer;
import com.chengbaiyi.remote.call.entity.MethodInfo;
import com.chengbaiyi.remote.call.interf.RestHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author xudongsheng
 * @title: WebClientRestHandler
 * @projectName remotecall
 * @description: TODO
 * @date 2019/3/12 16:52
 */
public class WebClientRestHandler implements RestHandler {

    private WebClient webClient;

    @Override
    public void initRestHandler(ApiServer annotation) {
        webClient = WebClient.create(annotation.domain());
    }

    @Override
    public Object handlerRequest(MethodInfo methodInfo) {
        WebClient.RequestBodySpec requestBodySpec = webClient.method(methodInfo.getHttpMethod()).uri(methodInfo.getUri(), methodInfo.getPathVariable())
                .contentType(methodInfo.getMediaType() == null ? MediaType.APPLICATION_JSON_UTF8 : methodInfo.getMediaType());
        if (methodInfo.getParams() != null){
            requestBodySpec.body(BodyInserters.fromObject(methodInfo.getParams()));
        }
        WebClient.ResponseSpec retrieve = requestBodySpec.retrieve();
        retrieve.onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.just(new RuntimeException("NOT FOND 400")));
        retrieve.onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.just(new RuntimeException("NOT FOND 5")));
        return null;
    }
}
