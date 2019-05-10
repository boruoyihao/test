package com.guava;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Booleans;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

/**
 * Created by zhaolizhen on 17-1-5.
 */
public class ComparableTest {

    public static void main(String args[]){
//        System.out.println(ComparisonChain.start().compare(2, 2).compare(1, 2).result());
        int array[]={1,3,2,0,9,4,7,8};
        Ordering<Student> ordering=Ordering.natural().onResultOf(new Function<Student, Comparable>() {
            @Nullable
            @Override
            public Comparable apply(Student input) {
                return input;
            }
        });

//        Ordering<Student> ordering=Ordering.natural();
        Student s1=new Student(2,"zbc");
        Student s2=new Student(2,"zbc");
        System.out.println(ordering.compare(s1,s2));
        System.out.println(new Student(12,null));
        System.out.println(Booleans.compare(true,true));
    }

    static class Student implements Comparable<Student>{
        @Nullable
        private int age;
        @NotNull
        private String name;

        public Student(int age,String name){
            this.age=age;
            this.name=name;
        }

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
            return Objects.toStringHelper(this).add("age",age).add("name",name).toString();
        }

        @Override
        public int compareTo(Student s) {
            return ComparisonChain.start().compare(this.age,s.age).compare(this.name,s.name).result();
        }

        @Override
        public int hashCode() {

            return Objects.hashCode(this);
        }
    }
}
