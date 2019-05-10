package com.executors;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhaolizhen on 17-4-26.
 */
public class ExecutorsTest {
    public static void main(String args[]){

        ExecutorService threadPool = Executors.newFixedThreadPool(3);//线程池中，3工作线程

        threadPool.execute(new Task("a"));
        threadPool.execute(new Task("b"));
        threadPool.execute(new Task("c"));
        threadPool.execute(new Task("d"));
        threadPool.execute(new Task("e"));
        threadPool.shutdown();
        while(!threadPool.isTerminated()){
        }
        System.out.println("Thread Pool is over");
    }
}

class Task implements Runnable{
    private String id;
    Task(String id){
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("Thread "+id+" is working");
        try {
            //每个任务随机延时1s以内的时间以模拟线程的运行
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread "+id+" over");
    }
}
