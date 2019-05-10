package com.thread.first;

/**
 * Created by zhaolizhen on 16-11-27.
 */
public class InterruptedThread1 extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 1000000; i++) {
                System.out.println("i=" + i);
            }
            System.out.println("run begin");
            Thread.sleep(20000);
        }catch (Exception e){
            System.out.println("先停止,遇到Sleep 进入catch");
            e.printStackTrace();
        }
    }
}
