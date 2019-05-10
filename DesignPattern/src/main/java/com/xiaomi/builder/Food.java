package com.xiaomi.builder;

import java.util.ArrayList;
import java.util.List;

public class Food {
    private List<Item>list=new ArrayList<Item>();
    public void addItem(Item item){
        list.add(item);
    }
    
    public void print(){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).name()+"  "+list.get(i).price()+" "+list.get(i).getPacking().getPacking());
        }
    }
}
