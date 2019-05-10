package com.pku.responsibility;

public class ERRORLogger extends AbstractLogger{

    public ERRORLogger(int level){
        this.level=level;
    }
    @Override
    public void write(String msg) {
        // TODO Auto-generated method stub
        System.out.println("ERROR+"+msg);
    }

}
