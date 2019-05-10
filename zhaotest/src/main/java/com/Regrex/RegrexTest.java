package com.Regrex;


import java.util.regex.Pattern;

/**
 * Created by zhaolizhen on 17-2-17.
 */
public class RegrexTest {
    private static String pattern="split+([0-9]|10)ChargeFee";
    public static void main(String args[]){
        System.out.println(Pattern.compile(pattern).matcher("split3ChargeFee").matches());
    }
}
