package com.xiaomi.filter;

import java.util.ArrayList;
import java.util.List;

public class AndCriteria implements Criteria{

    private Criteria firstCriteria;
    private Criteria secondCriteria;
    
public AndCriteria(Criteria firstCriteria,Criteria secondCriteria) {
    this.firstCriteria=firstCriteria;
    this.secondCriteria=secondCriteria;
}
    @Override
    public List<Student> filter(List<Student> studentList) {
        // TODO Auto-generated method stub
        List<Student>firstFilterResult=firstCriteria.filter(studentList);
        return secondCriteria.filter(firstFilterResult);
    }

}
