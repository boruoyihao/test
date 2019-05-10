package com.reflect;

import java.lang.reflect.Field;

/**
 * Created by zhaolizhen on 17-9-7.
 */
public class Reflect3 {
    public static void main(String args[]) throws IllegalAccessException {
        Class<?>cls=People.class;
        Object object=null;
        try {
            object=cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        for(Field f:cls.getDeclaredFields()){
            System.out.println(f.getName()+"_"+f.getType().getSimpleName());
            f.setAccessible(true);
            if(f.getName().equals("age")) {
                f.set(object, 12);
            }else if(f.getName().equals("name")){
                f.set(object,"zhaolizhen");
            }
        }


        System.out.println(object);
        System.out.println("0001884829673116".length());

        System.out.println(String.format("%s_%d","zhaolizhen",1));
    }
}

class People{
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
