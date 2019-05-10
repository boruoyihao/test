package com.xiaomi.strategy;

public class MultipyStrategy implements Strategy{

    private int no1;
    private int no2;
    public MultipyStrategy(int no1,int no2){
        this.no1=no1;
        this.no2=no2;
    }
    @Override
    public int doOperation() {
        // TODO Auto-generated method stub
        return no1*no2;
    }

}
