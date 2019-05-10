package com.webservice;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.facebook.swift.codec.ThriftConstructor;
import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftStruct;
import com.model.Student;
@ThriftStruct
public class Request {
//    @ThriftConstructor
    public Request(){
        
    }
    private int age;

    private List<String>l;
    
    private Map<String,String>m;
    
    private Set<Double>s;
    
    private List<Student>listStudent;
    
    @ThriftField(7)
    public List<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudent(List<Student> listStudent) {
        this.listStudent = listStudent;
    }
    private Student student;
    @ThriftField(6)
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ThriftField(5)
    public Set<Double> getS() {
        return s;
    }

    public void setS(Set<Double> s) {
        this.s = s;
    }

    @ThriftField(4)
    public Map<String, String> getM() {
        return m;
    }

    public void setM(Map<String, String> m) {
        this.m = m;
    }
    @ThriftField(1)
    public int getAge() {
        return age;
    }
    @ThriftField(3)
    public List<String> getL() {
        return l;
    }

    public void setL(List<String> l) {
        this.l = l;
    }

    public void setAge(int age) {
        this.age = age;
    }
@ThriftField(2)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
