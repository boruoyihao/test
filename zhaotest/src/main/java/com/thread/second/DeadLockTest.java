package com.thread.second;


/**
 * Created by zhaolizhen on 16-11-30.
 */
public class DeadLockTest {
    public static void main(String args[]){
        DeadLock deadLock=new DeadLock();

        deadLock.setName("a");
        Thread t1=new Thread(deadLock);
        t1.start();
        System.out.println(Thread.currentThread().getName());
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName());
        deadLock.setName("b");
        Thread t2=new Thread(deadLock);
        t2.start();
    }
}
