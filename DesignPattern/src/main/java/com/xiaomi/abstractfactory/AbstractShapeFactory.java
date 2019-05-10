package com.xiaomi.abstractfactory;

public class AbstractShapeFactory implements AbstractFactory {
    
    @Override
    public Shape getShape(String name) {
        // TODO Auto-generated method stub
        if(name.equalsIgnoreCase("circle")){
            return new Circle();
        }else if(name.equalsIgnoreCase("rect")){
            return new Rect();
        }
        return null;
    }
    
    @Override
    public Color getColor(String name) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
