package com.guava.Collections;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

/**
 * Created by zhaolizhen on 17-1-8.
 */
public class ClassToInstanceMapTest {
    public static void main(String args[]){
        ClassToInstanceMap<String> instanceMap= MutableClassToInstanceMap.create();
        instanceMap.putInstance(String.class,"dd");
        System.out.println(instanceMap);
    }
}
