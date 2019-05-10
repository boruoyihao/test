package com.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.guava.model.Student;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaolizhen on 17-1-10.
 */
public class CacheTest {
    public static Cache<String,Student> cache= CacheBuilder.newBuilder().expireAfterAccess(3, TimeUnit.SECONDS).maximumSize(5).build();

    public static void main(String args[]) throws ExecutionException, InterruptedException {
//        for(int i=0;i<10;i++){
//            Student student=getStudent("name"+(i%5));
//            System.out.println(student);
//        }

        for(int i=0;i<10;i++){
            Student student=getspecStudent("name" + (i % 5));
            System.out.println(student);
            if(i==6){
                Thread.sleep(3000);
            }
        }
    }

    static Student getStudent(String key){
        Student student=cache.getIfPresent(key);
        if(student!=null){
            System.out.println("get from cache");
            return student;
        }
        student=new Student(new Random().nextInt(30),key);
        System.out.println("get from db");
        cache.put(key,student);
        return student;
    }

    static Student getspecStudent(final String key) throws ExecutionException {
        return cache.get(key, new Callable<Student>() {
            @Override
            public Student call() throws Exception {
                System.out.println("get from db");
                return new Student(new Random().nextInt(30),key);
            }
        });
    }
}
