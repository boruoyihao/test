package com.xiaomi.proxy;

public class ProxyImage implements Image{

    private Image image=null;
    
    @Override
    public void printImage() {
        // TODO Auto-generated method stub
        if(null==image){
            image=new FlowerImage();
        }
        image.printImage();
    }

}
