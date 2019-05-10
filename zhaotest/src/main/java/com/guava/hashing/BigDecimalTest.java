package com.guava.hashing;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zhaolizhen on 17-2-13.
 */
public class BigDecimalTest {

    public static void main(String args[]){
        BigDecimal a1=new BigDecimal("10.5");
        BigDecimal a2=new BigDecimal("10.50");
        System.out.println(a1.equals(a2));
        System.out.println(a1.compareTo(a2));

        Date d=new Date(1496830940000L);
        System.out.println(d);

        System.out.println(new Date(1496823602000L));
        System.out.println(d.getTime()-System.currentTimeMillis());
    }
}
