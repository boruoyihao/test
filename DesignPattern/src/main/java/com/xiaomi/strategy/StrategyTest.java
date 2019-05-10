package com.xiaomi.strategy;

public class StrategyTest {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Strategy strategy=new AddStrategy(1,2);
        Context context=new ContextImpl();
        context.doOP(strategy);
        context.doOP(new MultipyStrategy(2, 3));
    }
    
}
