package com.thread.waitnotify;

/**
 * Created by zhaolizhen on 17-1-1.
 */
public class WaitNotifyTest {
    public static void main(String args[]){
        Object object=new Object();
        ThreadA threadA=new ThreadA(object);
        ThreadB threadB=new ThreadB(object);
        threadA.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadB.start();
    }
}
