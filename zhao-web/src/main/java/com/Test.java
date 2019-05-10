package com;

import org.apache.commons.lang.ObjectUtils;

import java.util.regex.Pattern;

/**
 * Created by zhaolizhen on 18-7-12.
 */
public class Test {
    public static void main(String args[]){
        System.out.println(doubleAmount2Long("0.7"));
        System.out.println(Long.valueOf("-075"));
    }

    public static String doubleAmount2Long(String doubleAmount) {
        if (ObjectUtils.equals(doubleAmount, "0")) {
            return "0";
        } else if (Pattern.matches("^\\d+\\.\\d{2}$", doubleAmount)) {
            System.out.println("TWO");
            return new StringBuilder(doubleAmount).deleteCharAt(doubleAmount.indexOf(".")).toString();
        } else if (Pattern.matches("^\\d+\\.\\d{4}$", doubleAmount)) {
            System.out.println("FOUR");
            return new StringBuilder(doubleAmount.substring(0, doubleAmount.length() - 2)).deleteCharAt(doubleAmount.indexOf("."))
                    .toString();
        } else if (Pattern.matches("^\\d+\\.\\d{1}$", doubleAmount)) {
            System.out.println("ONE");
            return new StringBuilder(doubleAmount).deleteCharAt(doubleAmount.indexOf(".")).append("0").toString();
        } else if (Pattern.matches("^\\d+$", doubleAmount)) {
            return new StringBuilder(doubleAmount).append("00").toString();
        } else {
            System.out.println("error input for doubleAmount2Long" + doubleAmount);
            return doubleAmount;
        }
    }
}
