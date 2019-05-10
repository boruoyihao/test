package com.guava;


import com.google.common.base.Objects;

/**
 * Created by zhaolizhen on 17-1-5.
 */
public class ObjectsTest {
    public static void main(String args[]){
        System.out.println(Objects.toStringHelper(String.class));
        System.out.println(Objects.toStringHelper("MyObject").add("x",1).toString());
        Student s=new Student();
        s.sedId(12);
        System.out.println(Objects.toStringHelper(s).add("id",12).toString());

    }
}
class Student{
    private int id;
    private String name;
    public Student sedId(int id){
        this.id=id;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}