package com.thread.first;

/**
 * Created by zhaolizhen on 16-11-27.
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + i + "is running");
                Thread.sleep(10);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
