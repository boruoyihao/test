package com.lock;

import com.inner.InnerTest;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhaolizhen on 17-5-16.
 */
public class CompaireSetTest {

    private static AtomicInteger atomicInteger=new AtomicInteger(3);

    private static Map<String,String> map=new ConcurrentHashMap<String,String>();
    public static void main(String args[]){
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 4));
        System.out.println(atomicInteger.get());
        new ArrayList<Integer>();
    }
}
