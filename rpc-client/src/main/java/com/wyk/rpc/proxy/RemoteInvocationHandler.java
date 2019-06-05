package com.wyk.rpc.proxy;

import com.wyk.rpc.transport.RpcNetTransport;
import com.wyk.rpc.vo.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: wyk
 * @Description:
 * @Date: Create in 2019/6/5 21:23
 * @Modified By:
 */
public class RemoteInvocationHandler implements InvocationHandler {

    private String host;

    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParamters(args);

        RpcNetTransport transport = new RpcNetTransport(host, port);
        Object result = transport.send(rpcRequest);

        return result;
    }
}
