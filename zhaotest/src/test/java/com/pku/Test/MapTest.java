package com.pku.Test;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.weakref.jmx.com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by zhaolizhen on 16-11-29.
 */
public class MapTest {
    static Map<String,String>m=new HashMap<String, String>();
    {
        m.put("dd","ee");

    }

    public static void main(String args[]){
//        String json="{}";
//        Map<String,String> map= JSON.parseObject(json, Map.class);
//        System.out.print(map==null);
//        Splitter splitter=Splitter.on(".");
//        String str="";
//        boolean result=Sets.newHashSet(splitter.omitEmptyStrings().split(str)).contains("123");
//        System.out.println(result);
//        System.out.println(splitter.split(str));
//
//        String str=null;
//        System.out.println(m.get(str));
//        System.out.println(m.get(null));


        System.out.println(new HashSet<Integer>().contains(null));
    }
}
