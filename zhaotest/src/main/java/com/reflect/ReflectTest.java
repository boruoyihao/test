package com.reflect;


import com.google.common.base.MoreObjects;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.thrift.TException;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by zhaolizhen on 17-2-8.
 */
public class ReflectTest {

    public static void main(String args[]){

        Map<String,Object> m=new HashMap<String,Object>();

        m.put("age",12);
        m.put("name","zhaolizhen");
        m.put("date",new Date());

        Person p=new Person();

//        transMap2Bean(m,p);
//        transMap2Bean2(m,p);
        Person pp=getSpecObject(m,Person.class);

        System.out.print(pp);

    }

    private static <T> T getSpecObject(Map<String, Object> resultMap,Class<T> cls) {
        try {
            T result=cls.newInstance();
            transMap2Bean(resultMap, result);
            return result;
        } catch (InstantiationException e) {

        } catch (IllegalAccessException e) {

        }
        return null;
    }


    // Map --> Bean 2: 利用org.apache.commons.beanutils 工具类实现 Map --> Bean
    public static void transMap2Bean2(Map<String, Object> map, Object obj) {
        if (map == null || obj == null) {
            return;
        }
        try {
            BeanUtils.populate(obj, map);
        } catch (Exception e) {
            System.out.println("transMap2Bean2 Error " + e);
        }
    }
    // Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean
    public static void transMap2Bean(Map<String, Object> map, Object obj) {

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor property : propertyDescriptors) {
                System.out.println("property:"+property);
                String key = property.getName();
                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    // 得到property对应的setter方法
                    Method setter = property.getWriteMethod();
                    setter.invoke(obj, value);
                }
            }
        } catch (Exception e) {
            System.out.println("transMap2Bean Error " + e);
        }
        return;
    }
}

class Person{
    private int age;
    private String name;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("age", age).add("name", name).add("date",date).toString();
    }
}
