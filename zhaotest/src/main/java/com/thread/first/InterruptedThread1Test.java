package com.thread.first;

/**
 * Created by zhaolizhen on 16-11-27.
 */
public class InterruptedThread1Test {
    public static void main(String args[]){
        InterruptedThread1 interruptedThread1=new InterruptedThread1();
        interruptedThread1.start();
        interruptedThread1.interrupt();
        System.out.println("end");
    }
}
