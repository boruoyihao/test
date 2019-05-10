package com.static1;

import java.util.Date;

/**
 * Created by zhaolizhen on 17-1-15.
 */
class Super{
    static {
        System.out.println("Super init");
    }
    static  int value=2;
}
public class staticTest {
    public static void main(String args[]){
        Super[]ss=new Super[10];
//        Super super2=new Super();
//        System.out.println(Super.value);
//        String str="ddd";

        String str="20161117RI432656202";

        System.out.print(str.compareTo("20170105"));

        System.out.println(new Date(System.currentTimeMillis()-24*3600*1000*20));
    }
}
