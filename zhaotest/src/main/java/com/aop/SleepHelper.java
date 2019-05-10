package com.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by zhaolizhen on 17-3-23.
 */
public class SleepHelper implements MethodBeforeAdvice,AfterReturningAdvice,MethodInterceptor {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before sleep");
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("after sleep");
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long start =System.currentTimeMillis();
        System.out.println("Round Advise 执行前,start="+start);
        Object result=invocation.proceed();
        Thread.sleep(1000);
        System.out.println("Round Advise 执行后,time="+(System.currentTimeMillis()-start));
        return result;
    }
}
