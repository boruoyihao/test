package com.aop;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by zhaolizhen on 17-3-23.
 */
@Aspect
public class SleepHelper2 {
    @Before("SleepPoint()")
    public void beforeSleep(){
        System.out.println("before sleep2");
    }

    @AfterReturning("SleepPoint()")
    public void afterSleep(){
        System.out.println("after sleep2");
    }

    @Pointcut("execution(* *.sleep())")
    public void SleepPoint(){
        System.out.println("SleepPoint");
    }
}
