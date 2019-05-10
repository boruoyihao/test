package com.extend;

/**
 * Created by zhaolizhen on 17-11-30.
 */
public class ExtendTest {

    public static void main(String args[]){
        Children parent=new Children();
        parent.name="dd";
        System.out.println(parent.getClass().equals( Parent.class));
    }
}
