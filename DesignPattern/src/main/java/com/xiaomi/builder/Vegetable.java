package com.xiaomi.builder;

public class Vegetable implements Item{

    @Override
    public String name() {
        // TODO Auto-generated method stub
        return "vegetable";
    }

    @Override
    public String price() {
        // TODO Auto-generated method stub
        return "4";
    }

    @Override
    public Packing getPacking() {
        // TODO Auto-generated method stub
        return new Unpack();
    }

}
