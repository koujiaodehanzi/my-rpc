package com.wyk.rpc.transport;

import com.wyk.rpc.vo.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @Author: wyk
 * @Description:
 * @Date: Create in 2019/6/5 21:29
 * @Modified By:
 */
public class RpcNetTransport {

    private String host;

    private int port;

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

   public Object send(RpcRequest rpcRequest){
       Socket socket = null;
       Object result = null;
       ObjectInputStream objectInputStream = null;
       ObjectOutputStream objectOutputStream = null;
       try {
           socket = new Socket(host, port);
           objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
           objectOutputStream.writeObject(rpcRequest);
           objectOutputStream.flush();

           objectInputStream = new ObjectInputStream(socket.getInputStream());
           result = objectInputStream.readObject();

       } catch (IOException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }finally {
           try {
               objectOutputStream.close();
               objectInputStream.close();
               socket.close();
           }catch (Exception e){
               e.printStackTrace();
           }
       }
       return result;
   }

}
