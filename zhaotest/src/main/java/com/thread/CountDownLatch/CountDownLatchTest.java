package com.thread.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhaolizhen on 17-6-15.
 */
public class CountDownLatchTest {

    private static CountDownLatch begin=new CountDownLatch(1);

    private static CountDownLatch end=new CountDownLatch(8);

    public static void main(String args[]){
        long start=System.currentTimeMillis();


        ExecutorService exe = Executors.newFixedThreadPool(8);

        Palayer palayers[]=new Palayer[8];
        for(int i=0;i<8;i++){

            palayers[i]=new Palayer(begin,end,"Palyer"+i);
            exe.execute(palayers[i]);
        }

//        for(Palayer palayer:palayers){
//            exe.execute(palayer);
//        }

        System.out.println("game start");


        begin.countDown();

        try {
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("game end");
        }

        System.out.println("cost:"+(System.currentTimeMillis()-start));
    }

}

class Palayer implements Runnable{

    private CountDownLatch begin;

    private CountDownLatch end;

    private String name;

    public Palayer(CountDownLatch begin,CountDownLatch end,String name){
        this.begin=begin;
        this.end=end;
        this.name=name;
    }

    @Override
    public void run() {
        try {
            begin.await();
            System.out.println(name+"is running");
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            end.countDown();
        }
    }
}
