package com.pku.command;

import java.util.ArrayList;
import java.util.List;

public class Broker {
    private List<Order>list=new ArrayList<Order>();
    
    public void takeOrder(Order order){
        list.add(order);
    }
    
    public void executeOrder(){
        for(Order order:list){
            order.execute();
        }
    }
}
