package com.reflect;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by zhaolizhen on 17-3-14.
 */
public class Reflect2 {
    public static void main(String args[]) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        Class<SS>cls=SS.class;
//        SS s=cls.newInstance();
//        s.setAge(12);
//        Method method=cls.getMethod("getAge");
//        Integer integer=(Integer)method.invoke(s);
//        System.out.println(integer);

//        Method method[]=cls.getMethods();
//        for (Method method1:method){
//            System.out.println(method1.getName()+"_"+method1.getModifiers()+"_"+
//                    Arrays.toString(method1.getParameterTypes()+method1.getAnnotationsByType()));
//        }
//        Method a=new Method();
//        Annotation[] annotations=cls.getAnnotations();
//        System.out.println(annotations.length);
//        for(Annotation annotation:annotations){
////            thrift t=(thrift)annotation;
////            System.out.println(t.name());
//            cls.
//        }

//        Field fields[]=cls.getDeclaredFields();
//        for(Field field:fields){
//            System.out.println(field.getName());
//        }

    }


}

@thrift
class SS{
    private int age;
    private String name;

    public int getAge() {
        System.out.println("getAge");
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
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface thrift{
    String name() default "Hello";
}





