package com.effectivejava;

import java.util.EnumSet;

/**
 * Created by zhaolizhen on 17-3-3.
 */
public class Forth {
    public static void main(String args[]){
        EnumSet<FruitEnum>e=EnumSet.<FruitEnum>of(FruitEnum.APPLE,FruitEnum.BANANA,FruitEnum.ORANGE);
        System.out.println(e);
    }


}

enum FruitEnum{
    APPLE,ORANGE,BANANA
}

class UtilityClass{
    private UtilityClass(){
        throw  new AssertionError("不能初始化");
    }

    public void each(){
    }
}