package com.pku.Flyweight;

class Circle implements Shape{

    private String color;
    
    private int radius;
    
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public Circle(String color,int radius){
        this.color=color;
        this.radius=radius;
        
    }
    @Override
    public void draw() {
        // TODO Auto-generated method stub
        System.out.println("color="+color+",radius="+radius);
    }

}
