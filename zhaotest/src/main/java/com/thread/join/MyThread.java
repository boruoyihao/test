package com.thread.join;

/**
 * Created by zhaolizhen on 16-12-31.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        int second=(int)(Math.random()*10000);
        System.out.println(second);
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
