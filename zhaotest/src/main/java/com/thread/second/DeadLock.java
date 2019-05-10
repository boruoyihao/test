package com.thread.second;

/**
 * Created by zhaolizhen on 16-11-30.
 */
public class DeadLock implements Runnable{

    private Object object1=new Object();
    private Object object2=new Object();

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public DeadLock(){}
    public DeadLock(String name){
        this.name=name;
    }


    @Override
    public void run() {
        if("a".equals(name)) {
            synchronized (object1) {
                System.out.println(Thread.currentThread().getName()+" object1 is occupied");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (object2) {
                    System.out.println("objetc2 is in object1 lock");
                }
            }
        }else{
            synchronized (object2) {
                System.out.println(Thread.currentThread().getName()+" object2 is occupied");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1) {
                    System.out.println("objetc1 is in object2 lock");
                }
            }
        }
    }
}
