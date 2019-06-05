package com.wyk.service;

import com.wyk.rpc.service.IHelloService;
import com.wyk.service.impl.HelloServiceImpl;
import com.wyk.service.proxy.RpcProxyServer;

/**
 * @Author: wyk
 * @Description:
 * @Date: Create in 2019/6/5 21:18
 * @Modified By:
 */
public class App {

    public static void main(String[] args) {
        IHelloService helloService = new HelloServiceImpl();

        RpcProxyServer rpcProxyServer = new RpcProxyServer();
        rpcProxyServer.publisher(8080, helloService);
    }

}
