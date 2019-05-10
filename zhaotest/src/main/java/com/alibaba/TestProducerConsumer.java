package com.alibaba;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by zhaolizhen on 18-5-22.
 */
public class TestProducerConsumer {

    //消费者线程
    private static ListeningExecutorService listeningExecutorConsumer =
            MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor());

    //生产者-消费者 阻塞队列
    private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();

    //保存结果的List,因为消费者只有一个，不用考虑线程并发处理的情况
    private static List<Integer> result = new ArrayList<Integer>();

    //生产者线程池
    private static ExecutorService executorProducer = Executors.newFixedThreadPool(10);

    public static void main(String args[]) {
        for (int i = 0; i < 10; i++) {
            executorProducer.execute(new Producer(queue));
        }

        ListenableFuture<?> listenableFuture = listeningExecutorConsumer.submit(new Consumer(queue, result));


        //消费者处理完，再对result进行排序。
        ListenableFuture listenableFutureResult = Futures.whenAllComplete(listenableFuture).call(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                Collections.sort(result);
                System.out.println("result:" + result);
                return true;
            }
        });

        //处理完后，关闭线程池 释放资源
        if (listenableFutureResult.isDone()) {
            executorProducer.shutdown();
            listeningExecutorConsumer.shutdown();
        }

    }
}
