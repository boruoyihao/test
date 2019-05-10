package com.thread.first;

/**
 * Created by zhaolizhen on 16-11-27.
 */
public class CountOperateTest {

    public static void main0(String args[]){
        CountOperate countOperate=new CountOperate();
        Thread t=new Thread(countOperate);
        //t.start();// main线程创建CounOperate线程,交给线程管理器执行
        t.run(); //同步 main线程执行
    }

    public static void main(String args[]){
        CountOperate countOperate=new CountOperate();
//        countOperate.start();
        countOperate.run();
    }
}
