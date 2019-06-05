package com.wyk.service.handler;


import com.wyk.rpc.vo.RpcRequest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @Author: wyk
 * @Description:
 * @Date: Create in 2019/6/5 21:03
 * @Modified By:
 */
public class ProcessHandler implements Runnable {

    private Socket socket;

    private Object service;

    public ProcessHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            // 获取调用信息 哪个类、哪个方法、方法参数
            RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();
            // 调用具体的方法
            Object result = this.invoke(rpcRequest);

            // 构造返回结果
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();

        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }

    private Object invoke(RpcRequest rpcRequest) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 反射调用

        // 1.获取请求参数
        Object[] paramters = rpcRequest.getParamters();
        // 2.获取请求参数的类型
        Class<?>[] types = new Class[paramters.length];
        for (int i=0; i<paramters.length; i++){
            types[i] = paramters[i].getClass();
        }
        // 3.加载调用类的class
        Class clazz = Class.forName(rpcRequest.getClassName());
        // 4.获取调用方法
        Method method = clazz.getMethod(rpcRequest.getMethodName(), types);
        // 5.反射调用
        Object result = method.invoke(service, paramters);
        return result;
    }
}
