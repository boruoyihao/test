package com.xiaomi.composite;

public class CompositeTest {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Employee ceo=new Employee(1, "CEO");
        Employee manager=new Employee(2, "MANAGER");
        Employee experter=new Employee(2, "EXPERTER");
        Employee worker=new Employee(3, "WORKER");
        Employee workder1=new Employee(4, "WORKER1");
        Employee worker2=new Employee(5, "WORKER2");
        Employee workder3=new Employee(6, "WORKER3");
        ceo.add(manager);
        manager.add(worker);
        manager.add(workder1);
        ceo.add(experter);
        experter.add(worker2);
        experter.add(workder3);
        dfs(ceo);
    }
    
    static void dfs(Employee employee){
        System.out.println(employee);
        for(Employee e:employee.getList()){
            dfs(e);
        }
    }
}
