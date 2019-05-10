package com.thread;

/**
 * Created by zhaolizhen on 16-11-27.
 */
public class ThreadTest {
    public static void main(String args[]){
        System.out.print("Hello");
        ThreadA ta=new ThreadA();
        new Thread(ta).start();
        System.out.println("END");

        int i=4;
        System.out.println("dd"+(i--));
    }
}

class ThreadA implements Runnable{

    @Override
    public void run() {
        System.out.println("run");
    }
}
