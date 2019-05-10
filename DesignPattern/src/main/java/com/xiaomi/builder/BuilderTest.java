package com.xiaomi.builder;

public class BuilderTest {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Food food1=BuilderFood.getFood1();
        Food food2=BuilderFood.getFood2();
        food1.print();
        food2.print();
    }
    
}
