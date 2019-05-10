package com.guava.Collections;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multiset;

/**
 * Created by zhaolizhen on 17-1-8.
 */
public class MultSetTest {

    public static void main(String args[]){
        HashMultimap<String, String> map= HashMultimap.create();
        map.put("dd","zhao");
        map.put("dd","zhang");
        System.out.println(map.get("dd").size());
        
    }
}
