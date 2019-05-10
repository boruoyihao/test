package com.thread.threadlocal;

import java.util.Date;

/**
 * Created by zhaolizhen on 16-12-31.
 */
public class ThreadA extends Thread {
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            if(Tools.t1.get()==null){
                Tools.t1.set(new Date());
            }
            System.out.println("Thread A "+Tools.t1.get());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
