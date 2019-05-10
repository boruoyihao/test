package com.thread.join;


/**
 * Created by zhaolizhen on 16-12-31.
 */
public class JoinTest {
    public static void main(String args[]){
        MyThread mt=new MyThread();
        mt.start();
        try {
            mt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finished");
    }
}
