package com.xiaomi.composite;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int no;
    private String name;
    private List<Employee> list=new ArrayList<Employee>();
    public List<Employee> getList() {
        return list;
    }
    public Employee(int no,String name){
        this.no=no;
        this.name=name;
    }
    public void add(Employee employee){
        list.add(employee);
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Employee [no=" + no + ", name=" + name + "]";
    }
    
    
}
