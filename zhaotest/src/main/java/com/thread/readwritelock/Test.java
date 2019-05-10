package com.thread.readwritelock;

/**
 * Created by zhaolizhen on 17-1-1.
 */
public class Test {
    public static void main(String args[]){
        Service service=new Service();
        ThreadA threadA=new ThreadA(service);
        ThreadB threadB=new ThreadB(service);
        threadA.start();
        threadB.start();
    }
}
