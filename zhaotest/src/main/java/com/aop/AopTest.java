package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhaolizhen on 17-3-23.
 */
public class AopTest {
    public static void main0(String args[]){
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("config/aop.xml");
        Sleepable sleeper=(Sleepable)appCtx.getBean("humanProxy");
        sleeper.sleep();
    }

    public static void main1(String args[]){
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("config/aop.xml");
        Sleepable human = (Sleepable)appCtx.getBean("human");
        human.sleep();
    }

    public static void main(String args[]){
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("config/aop.xml");
        Sleepable human = (Sleepable)appCtx.getBean("human2");
        human.sleep();
    }
}
