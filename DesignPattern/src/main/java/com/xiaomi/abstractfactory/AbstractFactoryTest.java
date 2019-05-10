package com.xiaomi.abstractfactory;

public class AbstractFactoryTest {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AbstractFactory shapeFactory=FactoryProduce.getAbstractFactory("shape");
        AbstractFactory colorFactory=FactoryProduce.getAbstractFactory("color");
        Shape rect=shapeFactory.getShape("rect");
        Shape circle=shapeFactory.getShape("circle");
        Color red=colorFactory.getColor("red");
        Color blue=colorFactory.getColor("blue");
        rect.draw();
        circle.draw();
        red.see();
        blue.see();
    }
    
}
