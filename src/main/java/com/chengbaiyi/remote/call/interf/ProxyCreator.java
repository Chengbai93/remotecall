package com.chengbaiyi.remote.call.interf;

/**
 * @author xudongsheng
 * @title: ProxyCreator
 * @projectName remotecall
 * @description: TODO
 * @date 2019/3/12 11:24
 */
public interface ProxyCreator {

    Object createProxy(Class<?> type);
}
