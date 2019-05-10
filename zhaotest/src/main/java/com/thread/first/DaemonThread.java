package com.thread.first;

/**
 * Created by zhaolizhen on 16-11-27.
 */
public class DaemonThread extends Thread {
    private int i=0;

    @Override
    public void run() {
        try{
            while(true){
                i++;
                System.out.println("i="+i);
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
