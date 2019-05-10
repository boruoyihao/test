package com.xiaomi.template;

public abstract class GeneralProcess implements Process{

    @Override
    public void process() {
        // TODO Auto-generated method stub
        init();
        start();
        finished();
    }

    protected abstract void init();
    
    protected abstract void start();
    
    protected abstract void finished();
}
