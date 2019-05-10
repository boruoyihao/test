package com.guava.string;

import com.google.common.base.Strings;

/**
 * Created by zhaolizhen on 17-2-9.
 */
public class CompaireTest {
    public static void main(String args[]){
        System.out.println("20160601".compareTo("20160531")>0);
        System.out.println("20160601".compareTo("20160601"));
        System.out.println(new StringBuilder("2016011319291856").reverse().toString());
    }
}
