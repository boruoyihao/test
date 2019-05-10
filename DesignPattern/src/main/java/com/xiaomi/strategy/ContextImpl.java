package com.xiaomi.strategy;

public class ContextImpl implements Context{

    public ContextImpl(){
        
    }

    @Override
    public void doOP(Strategy strategy) {
        // TODO Auto-generated method stub
        System.out.println(strategy.getClass()+" "+strategy.doOperation());
    }

}
