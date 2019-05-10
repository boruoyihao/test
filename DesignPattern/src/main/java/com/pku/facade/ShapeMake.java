package com.pku.facade;

public class ShapeMake {
    private Shape circle;
    private Shape rectangle;
    
    public ShapeMake(Shape circle,Shape rectangle){
        this.circle=circle;
        this.rectangle=rectangle;
    }
    
    public void drawCircle(){
        circle.draw();
    }
    
    public void drawRectrangle(){
        rectangle.draw();
    }
}
