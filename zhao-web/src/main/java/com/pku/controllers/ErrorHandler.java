package com.pku.controllers;

import net.paoding.rose.web.ControllerErrorHandler;
import net.paoding.rose.web.Invocation;

public class ErrorHandler implements ControllerErrorHandler {

    @Override
    public Object onError(Invocation inv, Throwable ex) throws Throwable {
        // TODO Auto-generated method stub
        return null;
    }

//    @Override
//    public Object onError(Invocation inv, Throwable ex) throws Throwable {
//        // TODO Auto-generated method stub
//        if(ex instanceof Exception){
//            return "@exception";
//        }
//        return "500";
//    }

}
