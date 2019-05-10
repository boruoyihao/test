package com.map;

import com.beust.jcommander.internal.Lists;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaolizhen on 17-3-28.
 */
public class EnumMapTest {
    private static final int[]array=new int[0];
    private static final Integer[]array1=new Integer[0];
    private static List<Integer> list=Lists.newArrayList();

    public static void main(String args[]){
        Map<Fruit,String> m=new EnumMap<Fruit,String>(Fruit.class);
        System.out.println(Fruit.class.getEnumConstants());
        System.out.println(Arrays.asList(1, 2, 3));
        System.out.println(array[0]);
        System.out.println(list.toArray(array1));
    }


}

enum Fruit{
    APPLE,BALANA;
}


