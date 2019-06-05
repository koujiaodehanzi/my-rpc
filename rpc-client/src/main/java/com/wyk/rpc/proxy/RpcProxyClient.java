package com.wyk.rpc.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author: wyk
 * @Description:
 * @Date: Create in 2019/6/5 21:21
 * @Modified By:
 */
public class RpcProxyClient {

    public <T> T clientProxy(final Class<T> interfaceClas, final String host, final int port){

        return (T)Proxy.newProxyInstance(interfaceClas.getClassLoader(), new Class[]{interfaceClas}, new RemoteInvocationHandler(host, port));
    }

}
