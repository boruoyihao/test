package com.pku.responsibility;

public class DebugLogger extends AbstractLogger{

    public DebugLogger(int level){
       this.level=level;
    }
    @Override
    public void write(String msg) {
        // TODO Auto-generated method stub
        System.out.println("Debug,"+msg);
    }

}
