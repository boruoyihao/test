package com.thread.first;

/**
 * Created by zhaolizhen on 16-11-27.
 */
public class RunnableTest {
    public static void main(String args[]){
        Runnable runnable=new MyRunnable();
        Thread thread=new Thread(runnable,"Thread1");
        thread.start();
//        thread.run();
        System.out.println("running over");
    }
}
/**
 * running over
 * Thread1 is running
 */