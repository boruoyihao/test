package com.proxy;


import java.lang.reflect.Proxy;

/**
 * Created by zhaolizhen on 17-3-21.
 */
public class SecurityProxyTest {
    public static void main(String args[]){
        Student s=new StudentImpl();
        s.setAge(12);
        SecurityProxyInvocationHandler securityProxyInvocationHandler=new SecurityProxyInvocationHandler(s);


        Student student= (Student)Proxy.newProxyInstance(Student.class.getClassLoader(),new Class[]{Student.class},securityProxyInvocationHandler);
        System.out.println(student.getAge());
    }
}
interface Student{
    public int getAge();
    public void setAge(int age);
    public String getName();
    public void setName(String name);
}
class StudentImpl implements Student{
    private int age;
    private String name;

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
}
