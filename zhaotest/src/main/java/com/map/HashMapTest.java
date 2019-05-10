package com.map;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaolizhen on 17-6-2.
 */
public class HashMapTest {
    public static void main(String args[]){
        Map<Student,String> m=new HashMap<Student,String>();
        m.put(new Student(1,"zhao"),"12");
        m.put(new Student(2,"zhao"),"13");
        System.out.println(JSONObject.toJSON(m));
    }
}

class Student{
    private int id;
    private String name;

    public Student(int id,String name){
        this.id=id;
        this.name=name;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
//        return super.hashCode();
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
