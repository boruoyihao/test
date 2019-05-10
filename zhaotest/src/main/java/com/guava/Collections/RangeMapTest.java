package com.guava.Collections;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

/**
 * Created by zhaolizhen on 17-1-8.
 */
public class RangeMapTest{
    public static void main(String args[]){
        RangeMap<Integer,String>map= TreeRangeMap.create();
        map.put(Range.closed(1,30),"dd");
        System.out.println(Range.closed(1,30));
        System.out.println(map.get(2));
    }
}
