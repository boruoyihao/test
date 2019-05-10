package com.pku.controllers;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.BitSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pku.annotation.Filter;

import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Dispatcher;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.InvocationChain;

public class AccessTrackInterceptor extends ControllerInterceptorAdapter {

    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub
        logger.info("zhaolizhen setName={}",name);
        super.setName(name);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        logger.info("zhaolizhen getName={}",super.getName());
        return super.getName();
    }

    @Override
    public int getPriority() {
        // TODO Auto-generated method stub
        logger.info("zhaolizhen getPriority={}",super.getPriority());
        return super.getPriority();
    }

    @Override
    public void setPriority(int priority) {
        // TODO Auto-generated method stub
        logger.info("zhaolizhen setPriority={}",priority);
        super.setPriority(priority);
    }

    @Override
    protected boolean isForAction(Method actionMethod, Class<?> controllerClazz) {
        // TODO Auto-generated method stub
        logger.info("zhaolizhen isForAction,actionMethod={},controllerClazz={}",actionMethod,controllerClazz);
        return super.isForAction(actionMethod, controllerClazz);
    }

    @Override
    public boolean isForDispatcher(Dispatcher dispatcher) {
        // TODO Auto-generated method stub
        logger.info("zhaolizhen isForDispatcher,disatchert={}",dispatcher);
        return super.isForDispatcher(dispatcher);
    }

    @Override
    protected Object round(Invocation inv, InvocationChain chain) throws Exception {
        // TODO Auto-generated method stub
        logger.info("zhaolizhen round");
        return super.round(inv, chain);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        logger.info("zhaolizhen toString");
        return super.toString();
    }

    @Override
    protected List<Class<? extends Annotation>> getRequiredAnnotationClasses() {
        // TODO Auto-generated method stub
        logger.info("zhaolizhen getRequiredAnnotationClasses");
        return super.getRequiredAnnotationClasses();
    }

    @Override
    protected List<Class<? extends Annotation>> getDenyAnnotationClasses() {
        // TODO Auto-generated method stub
        logger.info("zhaolizhen getDenyAnnotationClasses");
        return super.getDenyAnnotationClasses();
    }

    @Override
    protected Class<? extends Annotation> getDenyAnnotationClass() {
        // TODO Auto-generated method stub
        logger.info("zhaolizhen getDenyAnnotationClass");
        return super.getDenyAnnotationClass();
    }

    private static final Logger logger=LoggerFactory.getLogger(AccessTrackInterceptor.class);
    @Override
    protected Object before(Invocation inv) throws Exception {
        // TODO Auto-generated method stub
        logger.info("zhaolizhen before");
        return super.before(inv);
    }

    @Override
    protected Object after(Invocation inv, Object instruction) throws Exception {
        // TODO Auto-generated method stub
        logger.info("zhaolizhen after");
        return super.after(inv, instruction);
    }

    @Override
    public void afterCompletion(Invocation inv, Throwable ex) throws Exception {
        // TODO Auto-generated method stub
        logger.info("zhaolizhen afterCompletion");
        super.afterCompletion(inv, ex);
    }

    @Override
    protected BitSet getAnnotationScope(Class<? extends Annotation> annotationType) {
        // TODO Auto-generated method stub
        logger.info("zhaolizhen getAnnotationScope");
        return super.getAnnotationScope(annotationType);
    }

    @Override
    protected boolean checkAnnotation(Annotation annotation) {
        // TODO Auto-generated method stub
        logger.info("zhaolizhen checkAnnotation");
        return super.checkAnnotation(annotation);
    }

    @Override
    protected Class<? extends Annotation> getRequiredAnnotationClass() {
        // TODO Auto-generated method stub
        logger.info("zhaolizhen getRequiredAnnotationClass");
//        return super.getRequiredAnnotationClass();
        return Filter.class;
    }
    
}
