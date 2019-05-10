package com.guava.split;

import com.google.common.base.Splitter;
import org.weakref.jmx.com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by zhaolizhen on 17-2-20.
 */
public class SplitTest {
    static String str="12,         34       ,  56     ";
    public static void main(String args[]){
        Iterable<String>result=Splitter.on(",").omitEmptyStrings().trimResults().split(str);
        Set<String> ss=Sets.newHashSet(result);
        System.out.println(ss);

        System.out.println("zhaolizhen".endsWith("lizhen0"));


        System.out.println();
    }
}
