package com.guava.pritive;

import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.common.primitives.Shorts;
import com.guava.order.OO;

/**
 * Created by zhaolizhen on 17-2-24.
 */
public class PritiveTest {

    public static void main(String args[]){
        System.out.println(Booleans.countTrue(true,false,true));
        System.out.println(Shorts.checkedCast(12));
        System.out.println(Ints.fromByteArray(Ints.toByteArray(126)));
    }
}
