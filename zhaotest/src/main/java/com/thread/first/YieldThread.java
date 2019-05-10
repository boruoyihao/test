package com.thread.first;

/**
 * Created by zhaolizhen on 16-11-27.
 */
public class YieldThread extends Thread {
    @Override
    public void run() {
//        super.run();
        long begin=System.currentTimeMillis();
        int count=0;
        for(int i=0;i<50000000;i++){
//            Thread.yield();
            count+=i;

        }
        long end=System.currentTimeMillis();
        System.out.println("用时:"+(end-begin));
    }

}
