package com.thread.threadlocal;

import java.util.Date;

/**
 * Created by zhaolizhen on 16-12-31.
 */
public class ThreadLocalExt<T> extends ThreadLocal<T>{
    @Override
    protected T initialValue() {
        System.out.println(Thread.currentThread().getName()+" init");
        return (T)new Date();
    }
}
