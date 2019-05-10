package com.thread.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by zhaolizhen on 17-1-1.
 */
public class Service {
    private ReentrantReadWriteLock rrw=new ReentrantReadWriteLock();

    public void write(){

        try {
            rrw.writeLock().lock();
            System.out.println("写锁 start");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rrw.writeLock().unlock();
            System.out.println("写锁 finished");
        }
    }
}
