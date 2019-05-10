package com.pku.sample;


import org.slf4j.Logger;
import org.testng.annotations.Test;

import com.pku.base.TestBase;

public class TestHello extends TestBase{
    private static final Logger logger=org.slf4j.LoggerFactory.getLogger(TestHello.class);
    
    @Test
    public void testHello(){
        logger.info("hello world");
    }
}
