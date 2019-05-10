package com.guava.string;


import org.apache.commons.lang.StringUtils;

/**
 * Created by zhaolizhen on 17-3-16.
 */
public class ReversetTest {
    public static void main(String args[]){
        String str=StringUtils.reverse("20160112FI100515300");
        System.out.println(str);
//20160112FI100515300
        System.out.println(StringUtils.reverse("2016011319291856"));

        System.out.println(StringUtils.reverse("20160523122723113000101830186586"));
    }


}

interface A{
    int a() throws Exception;
}
