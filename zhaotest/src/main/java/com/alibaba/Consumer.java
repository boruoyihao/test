package com.alibaba;

import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zhaolizhen on 18-5-22.
 */

/**
 * 消费者
 * not thread-safe
 */
class Consumer implements Runnable {

    //缓冲队列
    private BlockingQueue<Integer> queue;

    //保存结果的列表
    private List<Integer> resultList;

    private static final int Modulofactor = (1 << 4) - 1;


    public Consumer(BlockingQueue<Integer> queue, List<Integer> resultList) {
        this.queue = queue;
        this.resultList = resultList;
    }

    @Override
    public void run() {
        while (!queue.isEmpty()) {
            Integer data = null;
            try {
                data = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //如果这个数能被16整除
            if ((data & Modulofactor) == 0) {
                resultList.add(data);
            }
        }
    }
}
