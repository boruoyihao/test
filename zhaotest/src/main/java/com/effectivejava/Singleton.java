package com.effectivejava;

public class Singleton {
    private static class SingletonHolder {
        static {
            System.out.println("singletonHolder Test");
        }
        private static final Singleton INSTANCE = new Singleton();
    }  
    private Singleton (){}  
    public static final Singleton getInstance() {  
       return SingletonHolder.INSTANCE;
    }

    public static final String getMsg(){
        return "hello";
    }
}   