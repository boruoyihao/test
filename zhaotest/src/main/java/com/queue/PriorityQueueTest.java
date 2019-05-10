package com.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by zhaolizhen on 17-11-30.
 */
public class PriorityQueueTest {
    public static void main(String args[]){
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int array[]={1,5,2,3,6,0,8,10,-1};
        for(int data:array){
            priorityQueue.offer(data);
        }

        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());
    }
}
