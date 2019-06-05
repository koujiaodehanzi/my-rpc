package com.wyk.rpc;

import com.wyk.rpc.proxy.RpcProxyClient;
import com.wyk.rpc.service.IHelloService;

/**
 * @Author: wyk
 * @Description:
 * @Date: Create in 2019/6/5 21:20
 * @Modified By:
 */
public class App {

    public static void main(String[] args) {

        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        IHelloService helloService = rpcProxyClient.clientProxy(IHelloService.class, "localhost", 8080);

        Object reulst = helloService.sayHello("5555");
        System.out.println(reulst);

    }

}
