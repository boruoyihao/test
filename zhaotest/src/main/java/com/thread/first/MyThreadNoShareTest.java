package com.thread.first;

/**
 * Created by zhaolizhen on 16-11-27.
 */
public class MyThreadNoShareTest {
    public static void main(String args[]){
        MyThreadNoShare myThreadNoShare1=new MyThreadNoShare("mythreadNoshare1");
        MyThreadNoShare myThreadNoShare2=new MyThreadNoShare("mythreadNoshare2");
        MyThreadNoShare myThreadNoShare3=new MyThreadNoShare("mythreadNoshare3");

        myThreadNoShare1.start();
        myThreadNoShare2.start();
        myThreadNoShare3.start();
    }

}

/**
 * mythreadNoshare1 is running,count=5
 mythreadNoshare1 is running,count=4
 mythreadNoshare1 is running,count=3
 mythreadNoshare1 is running,count=2
 mythreadNoshare1 is running,count=1
 mythreadNoshare2 is running,count=5
 mythreadNoshare2 is running,count=4
 mythreadNoshare2 is running,count=3
 mythreadNoshare2 is running,count=2
 mythreadNoshare3 is running,count=5
 mythreadNoshare3 is running,count=4
 mythreadNoshare3 is running,count=3
 mythreadNoshare3 is running,count=2
 mythreadNoshare3 is running,count=1
 mythreadNoshare2 is running,count=1
 */
