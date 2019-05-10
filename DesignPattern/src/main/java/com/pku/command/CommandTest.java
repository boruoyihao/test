package com.pku.command;

public class CommandTest {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stock stock =new Stock();
        Order buyStock=new BuyStock(stock);
        Order selleStock=new SellStock(stock);
        Broker broker=new Broker();
        broker.takeOrder(buyStock);
        broker.takeOrder(selleStock);
        broker.executeOrder();
    }
    
}
