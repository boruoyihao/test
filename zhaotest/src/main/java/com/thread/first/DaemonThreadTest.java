package com.thread.first;

/**
 * Created by zhaolizhen on 16-11-27.
 */
public class DaemonThreadTest {

    public static void main(String args[]){
        try {
            DaemonThread daemonThread = new DaemonThread();
            daemonThread.setDaemon(true);
            daemonThread.start();
            Thread.sleep(5000);
            System.out.println("I can't print when i leave the main thread");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
