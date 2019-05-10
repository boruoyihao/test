package com.xiaomi.builder;

public class Fruit implements Item{

    @Override
    public String name() {
        // TODO Auto-generated method stub
        return "fruit";
    }

    @Override
    public String price() {
        // TODO Auto-generated method stub
        return "3";
    }

    @Override
    public Packing getPacking() {
        // TODO Auto-generated method stub
        return new Pack();
    }

}
