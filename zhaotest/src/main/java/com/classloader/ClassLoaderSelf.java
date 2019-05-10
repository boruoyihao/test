package com.classloader;

/**
 * Created by zhaolizhen on 17-12-26.
 */
public class ClassLoaderSelf extends java.lang.ClassLoader  {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

}
