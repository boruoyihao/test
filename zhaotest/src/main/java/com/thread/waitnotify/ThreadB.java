package com.thread.waitnotify;

/**
 * Created by zhaolizhen on 17-1-1.
 */
public class ThreadB extends Thread {
    private Object object;

    public ThreadB(Object object){
        this.object=object;
    }
    @Override
    public void run() {
        synchronized (object){
            for(int i=0;i<10;i++){
                System.out.println("ThreadB "+i);
                if(i==3) {
                    object.notify();
                }
            }
        }
    }
}
