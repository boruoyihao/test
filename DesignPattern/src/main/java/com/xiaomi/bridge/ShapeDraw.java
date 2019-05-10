package com.xiaomi.bridge;


public class ShapeDraw extends Shape{

    private int r;
    private String color;
    
    public ShapeDraw(int r, String color, DrawAPI drawAPI) {
        super(drawAPI);
        this.r=r;
        this.color=color;
        // TODO Auto-generated constructor stub
    }

    @Override
    void draw() {
        // TODO Auto-generated method stub
        drawAPI.drawCircle(r, color);
    }
   

}
