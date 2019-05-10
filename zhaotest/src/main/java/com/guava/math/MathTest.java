package com.guava.math;

import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import org.apache.commons.math.util.MathUtils;

/**
 * Created by zhaolizhen on 17-1-10.
 */
public class MathTest {
    public static void main(String args[]){
        System.out.println(LongMath.checkedMultiply(4,3));
        System.out.println(IntMath.pow(2,10));
        System.out.println(IntMath.factorial(5));
        System.out.println(IntMath.isPowerOfTwo(1024));

    }
}
