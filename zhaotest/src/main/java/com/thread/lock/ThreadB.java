package com.thread.lock;

/**
 * Created by zhaolizhen on 17-1-1.
 */
public class ThreadB extends java.lang.Thread{

    public MyService myService;

    public ThreadB(MyService myService){
        this.myService=myService;
    }
    @Override
    public void run() {
        myService.awaitB();
    }
}
