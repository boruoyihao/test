package com.xiaomi.decorator;

public class ShapeDecorator implements Shape{

    private Shape shape;
    
    public ShapeDecorator decorator;
    
    public ShapeDecorator(Shape shape){
        this.shape=shape;
    }
    @Override
    public void draw() {
        // TODO Auto-generated method stub
        shape.draw();
    }

}
