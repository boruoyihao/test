package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zhaolizhen on 17-3-21.
 */
public class SecurityProxyInvocationHandler implements InvocationHandler {

    private Object proxyObject;

    public SecurityProxyInvocationHandler(Object proxyObject){
        this.proxyObject=proxyObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before="+method.getName());
        System.out.println("args"+args);
        if(proxyObject instanceof Student&&method.getName().equals("getAge")){
            System.out.println("CHECK");
        }
        return method.invoke(proxyObject,args);
    }
}
