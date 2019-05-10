package com.thread.threadlocal;

import java.util.Date;

/**
 * Created by zhaolizhen on 16-12-31.
 */
public class ThreadB extends Thread{
    @Override
    public void run() {
        for(int i=0;i<20;i++) {
            System.out.println("Tools.t1="+Tools.t1+",Tools.tt="+Tools.t);
            if (Tools.t1.get() == null) {
                Tools.t1.set(new Date());
            }
            System.out.println("Thread B " + Tools.t1.get());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
