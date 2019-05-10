package com.thread.waitnotify;

/**
 * Created by zhaolizhen on 16-12-31.
 */
public class ThreadA extends Thread{
    private Object object;

    public ThreadA(Object object){
        this.object=object;
    }

    @Override
    public void run() {
        synchronized (object){
            for(int i=0;i<10;i++){
                System.out.println("Thread A "+i);
                if(i==5){
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
