package com.xiaomi.bridge;

public abstract class Shape {

    protected DrawAPI drawAPI;
    public Shape(DrawAPI drawAPI){
        this.drawAPI=drawAPI;
    }
    abstract void draw();

}
