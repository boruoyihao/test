package com.xiaomi.builder;

public class Bread implements Item{

    @Override
    public String name() {
        // TODO Auto-generated method stub
        return "bread";
    }

    @Override
    public String price() {
        // TODO Auto-generated method stub
        return "0.5";
    }

    @Override
    public Packing getPacking() {
        // TODO Auto-generated method stub
        return new Pack();
    }

}
