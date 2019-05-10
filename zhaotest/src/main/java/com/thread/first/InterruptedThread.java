package com.thread.first;

/**
 * Created by zhaolizhen on 16-11-27.
 */
public class InterruptedThread extends Thread {
//    @Override
//    public void run() {
//        super.run();
//        for(int i=0;i<500000;i++){
//            if(this.isInterrupted()){
//                System.out.println("I want quit,cause its's stopped!");
//                break;
//            }
//            System.out.println("i="+(i+1)+" "+Thread.currentThread().getName());
//        }
//    }


    @Override
    public void run() {
        super.run();
        try {
            System.out.println("run begin");
            Thread.sleep(300000);
        }catch (Exception e){
            System.out.println("在沉睡中停止!进入catch="+this.isInterrupted());
            e.printStackTrace();
        }
    }
}
