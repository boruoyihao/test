package com.interview.jvm;

/**
 * Created by zhaolizhen on 17-9-15.
 */
class SingleTon {
    private static SingleTon singleTon = new SingleTon();
    public static int count1;
    public static int count2 = 0;

    private SingleTon() {
        count1++;
        count2++;
    }

    public static SingleTon getInstance() {
        return singleTon;
    }
}

class SuperClass {
    static {
        System.out.println("superclass init");
    }
    public static int value = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("subclass init");
    }
}
public class ClassLoader {
    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);

        System.out.println(SubClass.value);// 被动应用1
        SubClass[] sca = new SubClass[10];// 被动引用2

    }
}
