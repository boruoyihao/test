package com.pku.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactroy {
    
    private static final Map<String,Shape>m=new HashMap<String,Shape>();
    
    public static Shape getShape(String color){
        Shape shape=m.get(color);
        if(shape!=null){
            return shape;
        }
        m.put(color, new Circle(color,2));
        return m.get(color);
    }
}
