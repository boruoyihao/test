package com.xiaomi.decorator;

public class DecoratorTest {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Shape circleShape=new CircleShape();
        Shape recShape=new RectShape();
        Shape circleDecorator=new ShapeDecorator(circleShape);
        circleDecorator.draw();
        Shape recDecorator=new ShapeDecorator(recShape);
        recDecorator.draw();
    }
    
}
