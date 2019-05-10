package com.abstract1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhaolizhen on 17-9-18.
 */
public class Test {
    public static void main(String args[]){
//        Parent p=new Children();
//        System.out.println(getSuffixPsId("20170920140001185000030330086258"));

        List<Integer> list=new ArrayList<Integer>();

        list.add(10);
        list.add(1);
        list.add(5);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        System.out.println(list);
    }


    private static String getSuffixPsId(String transactionNo){
        return transactionNo.substring(transactionNo.length()-3);
    }
}

class Parent{
    {
        System.out.println(getClass());
    }
}

class Children extends Parent{

}

class A{
    static {
        System.out.println("static");
    }

    public static String getStr(){
        return "12";
    }
}