package com.wyk.service.proxy;

import com.wyk.service.handler.ProcessHandler;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: wyk
 * @Description:
 * @Date: Create in 2019/6/5 21:01
 * @Modified By:
 */
public class RpcProxyServer {

    ExecutorService executorService = Executors.newCachedThreadPool();

    public void publisher(int port, Object service){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true){
                Socket socket = serverSocket.accept();
                // 每个socket交给一个线程处理
                executorService.execute(new ProcessHandler(socket, service));

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }

}
