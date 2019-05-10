package com.thread.first;

/**
 * Created by zhaolizhen on 16-11-27.
 */
public class MyThreadNoShare extends Thread{
    private int count=5;
    public MyThreadNoShare(String name){
        this.setName(name);
    }
    @Override
    public void run() {
        super.run();
        try {
            while (count > 0) {
                System.out.println(this.getName() + " is running,count=" + count--);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
