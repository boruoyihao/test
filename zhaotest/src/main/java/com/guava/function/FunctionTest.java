package com.guava.function;


import com.beust.jcommander.internal.Lists;
import com.google.common.collect.Iterables;

import java.util.List;
import java.util.function.Function;

/**
 * Created by zhaolizhen on 17-1-10.
 */
public class FunctionTest {

    public static void main(String args[]){

        Function<String,Integer> function=new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                    return Integer.parseInt(s);
            }
        };

        Integer a=function.apply("123");
        System.out.println(a);

        List<O> array= Lists.newArrayList(new A(),new B());
        Iterable<B>result=Iterables.filter(array,B.class);
        System.out.println(result);
    }


}
class O{

}
class A extends O{
    @Override
    public String toString() {
        return "A";
    }
}
class B extends O{
    @Override
    public String toString() {
        return "B";
    }
}
