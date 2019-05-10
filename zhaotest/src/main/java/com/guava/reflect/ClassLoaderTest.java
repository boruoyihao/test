package com.guava.reflect;

import com.google.common.collect.Lists;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.Invokable;
import com.model.Student;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by zhaolizhen on 17-2-23.
 */
public class ClassLoaderTest {
    public static void main(String args[]) throws IOException {
        Student s=new Student();
        ClassLoader classLoader=Student.class.getClassLoader();
        ClassPath classpath = ClassPath.from(classLoader); // scans the class path used by classloader
        for (ClassPath.ClassInfo classInfo : classpath.getTopLevelClasses("com.model.Student")) {
            System.out.println(classInfo.getName());
        }



    }
}
