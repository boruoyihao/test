package com.thread;

/**
 * Created by zhaolizhen on 17-9-25.
 */
public class Test {
    public static void main(String[] args) {
        ThreadLocal<String>threadLocal=new ThreadLocal<String>();
        final TestStaticCode testStaticCode = new TestStaticCode();
        final TestStaticCode testStaticCode1 = new TestStaticCode();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                testStaticCode.test1();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                testStaticCode1.test2();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                testStaticCode1.test3();
            }
        });
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                testStaticCode1.test4();
            }
        });

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
