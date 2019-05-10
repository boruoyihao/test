package com.xiaomi.factory;

public class ShapeFactory {
    public static Shape getCircle(){
        return new Circle();
    }
    
    public static Shape getRect(){
        return new Rect();
    }
}
