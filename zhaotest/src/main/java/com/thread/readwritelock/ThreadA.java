package com.thread.readwritelock;

/**
 * Created by zhaolizhen on 17-1-1.
 */
public class ThreadA extends Thread{
    public Service service;

    public ThreadA(Service service){
        this.service=service;
    }
    @Override
    public void run() {
        service.write();
    }
}
