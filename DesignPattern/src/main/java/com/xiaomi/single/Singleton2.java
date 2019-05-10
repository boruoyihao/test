package com.xiaomi.single;

public class Singleton2 {
    private Singleton2(){
        
    }
    public static final Singleton2 getSingleton(){
        return SingleInner.INSTANCE;
    }
    public static class SingleInner{
           private static final Singleton2 INSTANCE = new Singleton2();  
    }
}
