package com.xiaomi.abstractfactory;

public class FactoryProduce {
    
     public static AbstractFactory getAbstractFactory(String name){
        if(name.equalsIgnoreCase("shape")){
            return new AbstractShapeFactory();
        }else if(name.equalsIgnoreCase("color")){
            return new AbstractColorFactory();
        }
        return null;
    }
}
