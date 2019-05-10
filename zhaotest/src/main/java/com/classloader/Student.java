package com.classloader;

import com.inner.InnerTest;

/**
 * Created by zhaolizhen on 17-1-24.
 */
public class Student {
    private int age;
    private String name;

    static {
        System.out.println("static Student");
    }

    {
        System.out.println("normal init");
    }

    public int getAge() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
