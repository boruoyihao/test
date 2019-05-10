package com.guava;

import com.google.common.base.Throwables;

/**
 * Created by zhaolizhen on 17-1-8.
 */
public class ThrowTest {
    public static void main(String args[]){

        method1();
        try {
            method2();
        }catch (Exception e){

        }


    }
    static void method1(){
//        int a=2/0;
        try {
            int a=2/0;
        }
        catch (Throwable e){
            System.out.println("chain:"+Throwables.getCausalChain(e));
            System.out.println("throw:" + Throwables.getRootCause(e));
            throw Throwables.propagate(e);
//            Throwables.throwIfUnchecked(e);
//            throw Throwables.propagate(e);
//            System.out.println("throws");
        }
    }

    static void method2() throws Exception{

    }
}
