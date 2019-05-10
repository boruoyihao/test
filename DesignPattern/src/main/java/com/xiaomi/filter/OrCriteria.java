package com.xiaomi.filter;

import java.util.ArrayList;
import java.util.List;

public class OrCriteria implements Criteria{

    private Criteria firstCriteria;
    private Criteria secondCriteria;
    
    public OrCriteria(Criteria firstCriteria,Criteria secondCriteria){
        this.firstCriteria=firstCriteria;
        this.secondCriteria=secondCriteria;
    }
    @Override
    public List<Student> filter(List<Student> studentList) {
        // TODO Auto-generated method stub
        List<Student>list=new ArrayList<Student>();
        list.addAll(firstCriteria.filter(studentList));
        for(Student s:studentList){
            if(!list.contains(s)){
                list.add(s);
            }
        }
        return list;
    }

}
