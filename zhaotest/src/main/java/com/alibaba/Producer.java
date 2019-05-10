package com.alibaba;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zhaolizhen on 18-5-22.
 */

/**
 * 用于生产10000个0-1024随机数
 * not thread-safe Producer
 */
class Producer implements Runnable {

    //每个生产者默认生产最大数
    private static final int maxLength = 10000;

    private BlockingQueue<Integer> queue;

    private static final Random random = new Random();

    //产生随机数大小不能超过borderLine
    private static final int borderLine = (1<<10)+1;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < maxLength; i++) {
            try {
                //随机数加入队列
                queue.put(random.nextInt(borderLine));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
