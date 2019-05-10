package com.callabe;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by zhaolizhen on 17-6-15.
 */
public class CallabeTest {

    private static final ExecutorService execute= Executors.newFixedThreadPool(4);
    public static void main(String args[]){
        FutureTask<Result> futureTask=new FutureTask<Result>(new SessionCallable());
/*        Thread thread=new Thread(futureTask);
        thread.start();*/
        execute.execute(futureTask);
        try {
            if(futureTask.isDone()) {
                Result result = futureTask.get();
                System.out.println(result);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Hello");

    }
}
