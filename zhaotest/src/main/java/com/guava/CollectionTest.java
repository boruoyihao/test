package com.guava;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by zhaolizhen on 17-6-30.
 */
public class CollectionTest {

    public static void main(String args[]){
        List<String> list=Lists.newArrayList("123","zhao","222");
        List<Object>result=Lists.transform(list, new Function<String, Object>() {
            @Nullable
            @Override
            public Object apply(String input) {
                return input+"dd";
            }
        });
        System.out.println(result);
    }
}
