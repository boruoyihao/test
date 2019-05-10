package com.pku.Test;

//import org.junit.Test;
import org.slf4j.Logger;
import org.testng.annotations.Test;

public class HelloTest extends TestBase{
    private static final Logger logger=org.slf4j.LoggerFactory.getLogger(HelloTest.class);
    
    @Test
    public void testHello(){
        logger.debug("hello world");
    }
}
