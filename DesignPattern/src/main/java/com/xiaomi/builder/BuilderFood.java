package com.xiaomi.builder;

public class BuilderFood {
    public static Food getFood1(){
        Food food=new Food();
        food.addItem(new Rice());
        food.addItem(new Fruit());
        return food;
    }
    
    public static Food getFood2(){
        Food food=new Food();
        food.addItem(new Bread());
        food.addItem(new Vegetable());
        return food;
    }
}
