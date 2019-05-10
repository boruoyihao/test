package com.aop;

/**
 * Created by zhaolizhen on 17-3-23.
 */
public class Human implements Sleepable {
    @Override
    public void sleep() {
        System.out.println("Ben is sleeping");
    }
}
