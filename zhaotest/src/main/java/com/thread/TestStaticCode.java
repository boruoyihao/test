package com.thread;

/**
 * <p>项目名称：Day_Day_Up<p>
 * <ul>
 * <li>1、版权所有：蘑菇街</li>
 * <li>2、开发日期：16/6/24</li>
 * <li>3、开发时间：上午12:34</li>
 * <li>4、作    者：dixun</li>
 * <li>5、包路径名：com.chen.dison.thread.synchronizeTest</li>
 * <li>6、用    途：</li>
 * </ul>
 */
public class TestStaticCode {
    String test1 = "110";
    Integer test2 = 220;


    public void test1() {

        synchronized (test1) {
            try {
                System.out.println("test1");
                Thread.sleep(5000L);
                System.out.println("test1 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void test2() {

        synchronized (test2) {
            try {
                System.out.println("test2");
                Thread.sleep(5000L);
                System.out.println("test2 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void test3() {

        synchronized (test1) {
            try {
                System.out.println("test3");
                Thread.sleep(5000L);
                System.out.println("test3 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void test4() {


        try {
            System.out.println("test4");
            Thread.sleep(3000L);
            System.out.println("test4 end");
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

    }


    public static void main(String[] args) {
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
