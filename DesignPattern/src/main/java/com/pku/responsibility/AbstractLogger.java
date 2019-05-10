package com.pku.responsibility;

public abstract class AbstractLogger {
    public static int DEBUG=3;
    public static int INFO=2;
    public static int ERROR=1;
    
    protected int level;
    protected AbstractLogger next;
    
    public void setNext(AbstractLogger logger){
        this.next=logger;
    }
    
    public void logger(int level,String msg){
        if(this.level<=level){
            write(msg);
        }
        if(next!=null){
            next.logger(level,msg);
        }
    }
    public abstract void write(String msg);
}
