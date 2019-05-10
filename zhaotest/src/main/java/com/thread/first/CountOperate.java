package com.thread.first;

/**
 * Created by zhaolizhen on 16-11-27.
 */
public class CountOperate extends Thread {

    public CountOperate(){
        System.out.println("CountOperate begin--");
        System.out.println("Thread.currentThread="+Thread.currentThread().getName());
        System.out.println("Thread.currentThread is alive="+Thread.currentThread().isAlive());

        System.out.println("this.thread getName="+this.getName());
        System.out.println("this.thread is alive="+this.isAlive());
        System.out.println("CountOperate end--");

    }
    @Override
    public void run() {
        System.out.println("CountOperate begin--");
        System.out.println("Thread.currentThread="+Thread.currentThread().getName());
        System.out.println("Thread.currentThread is alive="+Thread.currentThread().isAlive());

        System.out.println("this.thread getName="+this.getName());
        System.out.println("this.thread is alive="+this.isAlive());
        System.out.println("CountOperate end--");

    }
}
