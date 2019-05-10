package com.thread.first;

import com.thread.ThreadTest;

/**
 * Created by zhaolizhen on 16-11-27.
 */
public class InterruptedThreadTest {
    public static void main(String args[]){
        try {
            InterruptedThread interruptedThread = new InterruptedThread();
            interruptedThread.start();
            interruptedThread.sleep(2000);
            interruptedThread.interrupt();
            System.out.println("is Stop 1="+interruptedThread.interrupted()+" "+ Thread.currentThread().getName());
            System.out.println("is Stop 2="+interruptedThread.interrupted()+" "+Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }


//        Thread.currentThread().interrupt();
//        System.out.println("is stop1="+Thread.interrupted());
//        System.out.println("is stop2="+Thread.interrupted());

    }
}
