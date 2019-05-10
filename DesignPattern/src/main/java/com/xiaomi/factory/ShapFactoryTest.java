package com.xiaomi.factory;

public class ShapFactoryTest {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Shape circle=ShapeFactory.getCircle();
        circle.name();
        
        Shape rect=ShapeFactory.getRect();
        rect.name();
    }
    
}
