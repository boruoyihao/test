package com.pku.facade;

public class FacadeTest {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ShapeMake shapeMacker=new ShapeMake(new Circle(),new Rectangle());
        
        shapeMacker.drawCircle();
        
        shapeMacker.drawRectrangle();
    }
    
}
