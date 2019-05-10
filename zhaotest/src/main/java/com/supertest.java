package com;

/**
 * Created by zhaolizhen on 17-3-13.
 */
public class supertest {
    public static void main(String args[]){
        Parents children=new Parents("dd") {
            @Override
            public void test() {
                System.out.println("test");
            }
        };
    }
}

abstract class Parents{
    public Parents(String str){
        System.out.println("Parents");
    }

    public abstract void test();
}

