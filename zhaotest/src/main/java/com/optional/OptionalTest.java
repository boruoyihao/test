package com.optional;

import java.util.Optional;
import java.util.function.Function;

/**
 * Created by zhaolizhen on 17-8-8.
 */
public class OptionalTest {
    public static void main(String args[]){
        SS ss=new SS();
        ss.setName("zhao");
        System.out.println(Optional.ofNullable(ss).map(new Function<SS, String>() {
            @Override
            public String apply(SS ss) {
                return ss.getName();
            }
        }).orElse("UNKNOW"));
    }


   static class SS{
        private int age;
        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
