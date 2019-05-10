package com.xiaomi.filter;

import java.util.ArrayList;
import java.util.List;

public class AgeCriteria implements Criteria{

    @Override
    public List<Student> filter(List<Student> studentList) {
        // TODO Auto-generated method stub
        List<Student>result=new ArrayList<Student>();
        for(Student student:studentList){
            if(student.getAge()>20&&student.getAge()<40){
                result.add(student);
            }
        }
        return result;
    }

}
