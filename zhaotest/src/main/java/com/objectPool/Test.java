package com.objectPool;

/**
 * Created by zhaolizhen on 18-5-16.
 */
public class Test {

    public static void main(String args[]) throws CloneNotSupportedException {
        DBTrade trade1=new DBTrade();

        long start=System.currentTimeMillis();
        for(int i=0;i<10000000;i++) {
            DBTrade trade =(DBTrade) trade1.clone();
        }
        System.out.println(System.currentTimeMillis()-start);
    }
}
