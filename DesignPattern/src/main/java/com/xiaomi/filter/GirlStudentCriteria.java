package com.xiaomi.filter;

import java.util.ArrayList;
import java.util.List;

public class GirlStudentCriteria implements Criteria {

    @Override
    public List<Student> filter(List<Student> studentList) {
        // TODO Auto-generated method stub
        List<Student>result=new ArrayList<Student>();
        for(Student student:studentList){
            if(student.getSex().equals("GIRL")){
                result.add(student);
            }
        }
        return result;
    }

}
