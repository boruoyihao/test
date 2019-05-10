package com.xiaomi.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterTest {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Criteria boyCriteria=new BoyStudentCriteria();
        Criteria girlCriteria=new GirlStudentCriteria();
        Criteria andCriteria=new AndCriteria(boyCriteria, girlCriteria);
        Criteria orCriteria=new OrCriteria(boyCriteria, girlCriteria);
        
        List<Student>list=new ArrayList<Student>();
        list.add(new Student(12,"zhao","BOY"));
        list.add(new Student(13,"yu","GIRL"));
        list.add(new Student(14,"sun","BOY"));
        list.add(new Student(15,"yang","GIRL"));
        
        List<Student>boyCriteriaList=boyCriteria.filter(list);
        System.out.println(boyCriteriaList);
        
        List<Student>girlCriteriaList=girlCriteria.filter(list);
        System.out.println(girlCriteriaList);
        
        List<Student>andCriteriaList=andCriteria.filter(list);
        System.out.println(andCriteriaList);
        
        List<Student>orCriteriaList=orCriteria.filter(list);
        System.out.println(orCriteriaList);
    }
    
}
