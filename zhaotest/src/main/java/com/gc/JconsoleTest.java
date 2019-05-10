package com.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaolizhen on 17-1-15.
 */
public class JconsoleTest {
    public static void main(String args[]) throws InterruptedException {
        filleHeap(1000);
    }

    static class OOMObject{
        public byte[]placeholder=new byte[64*1024];
    }

    public static void filleHeap(int num) throws InterruptedException {
        List<OOMObject> list=new ArrayList<OOMObject>();
        System.out.println(Thread.currentThread().getName()+"start");
        for(int i=0;i<num;i++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.out.println("finisehd");
        System.gc();
    }
}
