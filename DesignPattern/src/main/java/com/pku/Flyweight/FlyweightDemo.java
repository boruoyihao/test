package com.pku.Flyweight;

import java.util.Random;

public class FlyweightDemo {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String colors[]={"RED","BLUE","GREEN","BLACK","WHILETE"};
        
        for(int i=0;i<10;i++){
            Circle circle=(Circle)ShapeFactroy.getShape(colors[(int) (Math.random()*colors.length)]);
            System.out.println(i+" ");
            circle.draw();
            circle.setRadius((int)Math.random()*100);
            
        }
    }
    
}
