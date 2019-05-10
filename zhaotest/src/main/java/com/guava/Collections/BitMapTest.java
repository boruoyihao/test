package com.guava.Collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * Created by zhaolizhen on 17-1-8.
 */
public class BitMapTest {
    public static void main(String args[]){
        BiMap<String,String> map= HashBiMap.create();
        map.put("ddd","zhao");
        System.out.println(map.get("ddd"));
        System.out.println(map.inverse().get("zhao"));
    }
}
