package com.guava;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaolizhen on 17-1-5.
 */
public class ListenerFutureTest {
    private static ListeningExecutorService listeningExecutorService=
            MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

    public static void main0(String args[]){

        final ListenableFuture<Integer> listenableFuture=listeningExecutorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                return 45;
            }
        });
        System.out.println("before get Value");

        listenableFuture.addListener(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(listenableFuture.get());
                    callBack();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        },listeningExecutorService);

        System.out.println("after get value");

    }


    static void callBack(){
        System.out.println("I'm callback");
    }
    public static void main(String args[]){

        final ListenableFuture<Integer> listenableFuture=listeningExecutorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                return 45;
            }
        });
        System.out.println("before get Value");
        Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                System.out.println("call success,result="+result);
                callBack();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
        System.out.println("after get value");

    }
}
