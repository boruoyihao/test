package com.thread.first;

/**
 * Created by zhaolizhen on 16-11-27.
 */
public class MyThreadShareTest {

    public static void main(String args[]){
        MyThreadShare myThreadShare=new MyThreadShare();

        Thread t1=new Thread(myThreadShare,"thread1");
        Thread t2=new Thread(myThreadShare,"thread2");
        Thread t3=new Thread(myThreadShare,"thread3");
        Thread t4=new Thread(myThreadShare,"thread2");
        Thread t5=new Thread(myThreadShare,"thread3");
        System.out.println("t1 is Alive="+t1.isAlive());

        t1.start();
        System.out.println("t1 is Alive="+t1.isAlive());

        t2.start();
        t3.start();
        t4.start();
        t5.start();
//        try {
//            t1.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}

