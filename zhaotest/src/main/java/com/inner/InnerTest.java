package com.inner;

/**
 * Created by zhaolizhen on 17-1-4.
 */
public class InnerTest {
    private static int a=3;
    private String b;

    public void test(){
        Student s=new Student();
    }

    class PeoPle{
        private  int c=4;
        public void getA(){
            System.out.print(a);
        }
    }

    public static class Student{
        public Student(){
            System.out.println("Student init");
        }
        private int d;
        public void getA(){
            System.out.println(a);
        }
    }

    static class SSS{
        public SSS(){
            System.out.println("SSS init");
        }
    }
}
