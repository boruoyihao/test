package com.reflect;


import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by zhaolizhen on 17-9-21.
 */
public class PropertyUtils {
    public static void main(String args[]) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
//        Student s=new Student();
        Student s=(Student)Student.class.newInstance();
        org.apache.commons.beanutils.PropertyUtils.setSimpleProperty(s, "name", "Jonhn");
        org.apache.commons.beanutils.PropertyUtils.setSimpleProperty(s, "age", 11);




//        System.out.println(s.getAge()+" "+s.getName());

//
//        try {
//            BeanUtils.setProperty(s,"name","John");
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }


        System.out.println(s.getAge()+" "+s.getName());
    }
}




