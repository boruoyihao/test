package com.classloader;

/**
 * Created by zhaolizhen on 17-1-24.
 */
public class ClassLoaderTest {

    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader=ClassLoader.getSystemClassLoader();
        Class<?> s=classLoader.loadClass("com.classloader.Student");
        System.out.println();
        Student ss= (Student) s.newInstance();
        System.out.println(ss);

        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        Class cls=Class.forName("com.classloader.Student");
        cls.newInstance();


        System.out.println(Student.class.getClassLoader());

    }
}
