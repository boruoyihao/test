package com.thread.first;

/**
 * Created by zhaolizhen on 16-11-27.
 */
public class Test {
    public static void main(String args[]){
        MyThread myThread=new MyThread();
        myThread.setName("myThread");
//        myThread.start();
        myThread.run();
        System.out.println("");
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + i + " is running");
                Thread.sleep(10);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
