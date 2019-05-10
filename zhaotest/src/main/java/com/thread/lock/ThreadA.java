package com.thread.lock;

/**
 * Created by zhaolizhen on 17-1-1.
 */
public class ThreadA extends java.lang.Thread{

    public MyService myService;

    public ThreadA(MyService myService){
        this.myService=myService;
    }
    @Override
    public void run() {
        myService.awaitA();
    }
}
