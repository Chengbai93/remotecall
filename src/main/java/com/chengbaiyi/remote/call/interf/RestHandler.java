package com.chengbaiyi.remote.call.interf;

import com.chengbaiyi.remote.call.annotation.ApiServer;
import com.chengbaiyi.remote.call.entity.MethodInfo;

import java.io.IOException;

public interface RestHandler {

    void initRestHandler(ApiServer annotation);

    Object handlerRequest(MethodInfo methodInfo) throws IOException;
}
