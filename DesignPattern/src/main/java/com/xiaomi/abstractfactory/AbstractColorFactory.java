package com.xiaomi.abstractfactory;

public class AbstractColorFactory implements AbstractFactory{

    @Override
    public Shape getShape(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Color getColor(String name) {
        // TODO Auto-generated method stub
        if(name.equalsIgnoreCase("red")){
            return new Red();
        }else if(name.equalsIgnoreCase("blue")){
            return new Blue();
        }
        return null;
    }
    
}
