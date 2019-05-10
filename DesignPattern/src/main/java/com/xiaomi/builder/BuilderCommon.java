package com.xiaomi.builder;

public class BuilderCommon {

public static void main(String args[]){
    Student s=Student.newStudent().setAge(12).setName("zhaolizhen");
    System.out.println(s);
}
}
