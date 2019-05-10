package com.proxy;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by zhaolizhen on 17-3-14.
 */
public class ProxyTest {
    public static void main(String args[]){
        Mother boy=new Boy();
        Mother girl=new Girl();
//        Mother proxy=new ProxyChildren(boy,girl);
//        proxy.process();
        Mother children=new Children(Lists.newArrayList(boy,girl));
        children.process();

    }
}
interface Mother{
    void process();
}

class Boy implements Mother{

    @Override
    public void process() {
        System.out.println("Boy");
    }
}

class Girl implements Mother{

    @Override
    public void process() {
        System.out.println("Girl");
    }
}


class Children implements Mother{
    private List<Mother> list;
    public Children(List<Mother> list){
        this.list=list;
    }


    @Override
    public void process() {
        for(Mother mother:list){
            mother.process();
        }
    }
}

class ProxyChildren implements Mother{

    private Mother boy;
    private Mother girl;

    public ProxyChildren(Mother boy,Mother girl){
        this.boy=boy;
        this.girl=girl;
    }


    @Override
    public void process() {
        boy.process();
        System.out.println("CHildren");
        girl.process();
    }
}
