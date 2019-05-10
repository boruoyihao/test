package com.annotation;

import java.lang.annotation.*;
import java.util.Arrays;

/**
 * Created by zhaolizhen on 17-3-22.
 */
public class AnonocationTest {
    public static void main(String args[]){
        Student s=new Student();
        Annotation[] array=s.getClass().getAnnotations();
        Annotation annotation=array[0];
        System.out.println(s);
    }
}

@Param
class Student{
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
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Param{

}
