package com.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhaolizhen on 17-1-1.
 */
public class LockTest {
    private Lock lock=new ReentrantLock();
    Condition condition=lock.newCondition();
    public static void main(String args[]){
        MyService myService=new MyService();
        ThreadA threadA=new ThreadA(myService);
        ThreadB threadB=new ThreadB(myService);
        threadA.start();
        threadB.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myService.signalAll_A();
    }
}
