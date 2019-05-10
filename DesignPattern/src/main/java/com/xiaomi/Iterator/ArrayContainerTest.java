package com.xiaomi.Iterator;

public class ArrayContainerTest {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Container<Integer> container=new ArrayContainer<Integer>(new Integer[]{1,2,3,4,5,6});
        Iterator<Integer> it=container.getIterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    
}
