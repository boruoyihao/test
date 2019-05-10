package com.thread.first;

/**
 * Created by zhaolizhen on 16-11-27.
 */
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is running");
    }
}
