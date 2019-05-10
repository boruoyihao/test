package com.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhaolizhen on 17-5-10.
 */
public class ReentrantLockTest {
    public static void main(String args[]){
        ReentrantLock reentrantLock=new ReentrantLock();
        reentrantLock.tryLock();
        Object object=new Object();
        synchronized (object){

        }
    }
}
