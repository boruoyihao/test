package com.pku.responsibility;

public class INFOLogger extends AbstractLogger{

    public INFOLogger(int level){
        this.level=level;
    }
    
    @Override
    public void write(String msg) {
        // TODO Auto-generated method stub
        System.out.println("INFO"+msg);
    }

}
