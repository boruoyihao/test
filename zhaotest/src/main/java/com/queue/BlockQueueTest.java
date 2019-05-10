package com.queue;


import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by zhaolizhen on 17-5-10.
 */
public class BlockQueueTest {
    public static void main(String args[]){
        BlockingDeque blockingDeque=new LinkedBlockingDeque();

        Productor p1=new Productor(blockingDeque);

        Consumer c1=new Consumer(blockingDeque);

        for(int i=0;i<10;i++){
            Thread productor=new Thread(p1);
            productor.start();
        }

        for(int i=0;i<5;i++){
            Thread consumer=new Thread(c1);
            consumer.start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        p1.stop();
        c1.stop();
    }
}

class Box{
    private String name;

    private Box(){}

    private Box(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public Box setName(String name) {
        this.name = name;
        return this;
    }

    public static Box getBox(){
        return new Box();
    }



    @Override
    public String toString() {
        return "Box{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Consumer implements Runnable{

    private Queue<Box> blockQueue;

    private boolean flag=true;


    public Consumer(Queue<Box> blockQueue){
        this.blockQueue=blockQueue;
    }

    public void stop(){
        flag=false;
    }

    @Override
    public void run() {
        while(flag){
            Box box=blockQueue.remove();
            System.out.println("consume:"+box);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Productor implements Runnable{

    private Queue<Box> blockQueue;

    private boolean flag=true;

    private Random random;


    public Productor(Queue blockQueue){
        this.blockQueue=blockQueue;
        random=new Random(1000);
    }

    public void stop(){
        flag=false;
    }

    @Override
    public void run() {
        while(flag){
            Box box= com.queue.Box.getBox().setName("box:"+random.nextInt());
            boolean add = blockQueue.add(box);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("product");
        }
    }

}
