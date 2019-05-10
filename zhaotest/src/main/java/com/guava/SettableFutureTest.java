package com.guava;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * Created by zhaolizhen on 17-1-5.
 */
public class SettableFutureTest {
    private static ListeningExecutorService listeningExecutorService=
            MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
    public static void main(String args[]){
        SettableFuture<Integer> s=SettableFuture.create();

        s.set(12);
        try {
            System.out.println(s.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
