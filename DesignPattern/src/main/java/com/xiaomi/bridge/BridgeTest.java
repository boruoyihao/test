package com.xiaomi.bridge;

public class BridgeTest {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DrawAPI drawAPI=new GreenCircle();
        Shape shape=new ShapeDraw(12, "red", drawAPI);
        shape.draw();
    }
    
}
