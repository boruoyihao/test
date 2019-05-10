package com.xiaomi.builder;

public class Rice implements Item{

    @Override
    public String name() {
        // TODO Auto-generated method stub
        return "rice";
    }

    @Override
    public String price() {
        // TODO Auto-generated method stub
        return "1";
    }

    @Override
    public Packing getPacking() {
        // TODO Auto-generated method stub
        return new Unpack();
    }

}
