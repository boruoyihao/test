package com.thread.threadlocal;

/**
 * Created by zhaolizhen on 16-12-31.
 */
public class ThreadLocalTest {

    public static void main(String args[]){
        Thread threadA=new ThreadA();
        Thread threadB=new ThreadB();
        threadA.start();
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();
    }
}
