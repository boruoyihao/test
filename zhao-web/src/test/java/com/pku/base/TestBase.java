package com.pku.base;

import org.springframework.util.Log4jConfigurer;

public class TestBase {
    static {
        initLogging();
    }

    private static void initLogging(){
        try{
            Log4jConfigurer.initLogging("src/test/resources/log4j.properties");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
