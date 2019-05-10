package com.guava.Collections;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;

/**
 * Created by zhaolizhen on 17-1-8.
 */
public class ImmutableSetTest {
    public static void main(String args[]){
        Set<String> s=ImmutableSet.of("a","a","b");
        System.out.println(s);
        Lists.newArrayList();
        List<Integer> l=ImmutableList.of(3,1,2,1,2,1);
        List<Integer>resul=Lists.transform(l, new Function<Integer, Integer>() {
            @Nullable
            @Override
            public Integer apply(Integer input) {
                if(input%2==1)
                    return input;
                else
                    return 0;
            }
        });
        System.out.println(resul);


    }
}
