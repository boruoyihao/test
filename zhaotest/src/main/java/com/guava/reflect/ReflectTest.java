package com.guava.reflect;

import com.google.common.reflect.Reflection;
import com.google.common.reflect.TypeToken;

import java.lang.reflect.Modifier;

/**
 * Created by zhaolizhen on 17-2-23.
 */
public class ReflectTest {
    public static void main(String args[]){
        TypeToken<String> stringTok = TypeToken.of(String.class);
        Reflection.initialize(SS.class);
        Reflection.getPackageName(SS.class);
    }

}

class SS{
    int a=2;
    static int b=3;
    static {
        System.out.println("static Hello");
    }
    {
        System.out.println("Hello");
    }
}
