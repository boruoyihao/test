package com.pku.responsibility;

public class ResponsibilityTest {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AbstractLogger debugLogger=new DebugLogger(AbstractLogger.DEBUG);
        
        AbstractLogger infoLogger=new INFOLogger(AbstractLogger.INFO);
        
        AbstractLogger errorLogger=new ERRORLogger(AbstractLogger.ERROR);
        
        debugLogger.setNext(infoLogger);
        infoLogger.setNext(errorLogger);
        
//        debugLogger.logger(AbstractLogger.DEBUG,"DEBUG MESSAGE");
//        System.out.println("------");
//        infoLogger.logger(AbstractLogger.INFO, "INFO MESSAGE");
//        System.out.println("------");
//        errorLogger.logger(AbstractLogger.ERROR, "ERROR MESSAGE");
        
        debugLogger.logger(AbstractLogger.DEBUG,"DEBUG MESSGAE");
        System.out.println("------");
        debugLogger.logger(AbstractLogger.INFO,"INFO MESSGAE");
        System.out.println("------");
        debugLogger.logger(AbstractLogger.ERROR,"ERROR MESSGAE");

    }
    
}
