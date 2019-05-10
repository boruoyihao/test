package com.xiaomi.single;

public class Single {
    private Single(){
        
    }
    private static volatile Single single=null;
    
    public static Single newSingle(){
        if(single==null){
            synchronized (Single.class) {
                if(null==single){
                    return new Single();
                }
            }
        }
        return single;
    }
}
