package com.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhaolizhen on 17-1-1.
 */
public class MyService {
    private Lock lock=new ReentrantLock();
    private Condition conditionA=lock.newCondition();
    private Condition conditionB=lock.newCondition();

    public void awaitA(){
        lock.lock();
        System.out.println("Begin awaitA " + Thread.currentThread().getName());
        try {
            conditionA.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end awaitA "+Thread.currentThread().getName());
        lock.unlock();
    }

    public void awaitB(){
        lock.lock();
        System.out.println("Begin awaitB " + Thread.currentThread().getName());
        try {
            conditionB.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end awaitB "+Thread.currentThread().getName());
        lock.unlock();
    }

    public void signalAll_A(){
        lock.lock();
        System.out.println("signalAll_A start");
        conditionA.signalAll();
        System.out.println("sinalAll_A finished");
        lock.unlock();
    }

    public void signalAll_B(){
        lock.lock();
        System.out.println("signalAll_B start");
        conditionB.signalAll();
        System.out.println("sinalAll_B finished");
        lock.unlock();
    }
}
