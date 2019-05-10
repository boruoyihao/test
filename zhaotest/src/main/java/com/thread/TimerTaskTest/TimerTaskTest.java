package com.thread.TimerTaskTest;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zhaolizhen on 17-1-2.
 */
public class TimerTaskTest {
    public static void main(String args[]){
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        },2000,2000);
        System.out.print("rr");
    }
}
