package com.thread.readwritelock;

/**
 * Created by zhaolizhen on 17-1-1.
 */
public class ThreadB extends Thread{
    public Service service;

    public ThreadB(Service service){
        this.service=service;
    }
    @Override
    public void run() {
        service.write();
    }
}
