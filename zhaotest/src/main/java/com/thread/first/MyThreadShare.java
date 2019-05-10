package com.thread.first;

/**
 * Created by zhaolizhen on 16-11-27.
 */
public class MyThreadShare extends Thread{
    private int count=5;
    @Override
    public void run() {
        super.run();
        try {
//            count--;
            System.out.println(this.getName() + " is running,count=" + count--);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
