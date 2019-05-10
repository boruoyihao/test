package com.enum1;

/**
 * Created by zhaolizhen on 17-1-2.
 */
public enum EnumTest {
    enumTest;
    private EnumTest(){
        System.out.println("EnumTest constructing");
    }

    public String getName(){
        return "zhaolizhen";
    }
}
