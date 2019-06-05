package com.wyk.rpc.vo;

import java.io.Serializable;

/**
 * @Author: wyk
 * @Description:
 * @Date: Create in 2019/6/5 21:07
 * @Modified By:
 */
public class RpcRequest implements Serializable {

    private String className;

    private String methodName;

    private Object[] paramters;



    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParamters() {
        return paramters;
    }

    public void setParamters(Object[] paramters) {
        this.paramters = paramters;
    }
}
