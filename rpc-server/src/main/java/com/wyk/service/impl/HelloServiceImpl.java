package com.wyk.service.impl;

import com.wyk.rpc.service.IHelloService;

/**
 * @Author: wyk
 * @Description:
 * @Date: Create in 2019/6/5 20:59
 * @Modified By:
 */
public class HelloServiceImpl implements IHelloService {

    @Override
    public Object sayHello(String msg) {
        System.out.println(msg);
        return msg + "66666";
    }
}
