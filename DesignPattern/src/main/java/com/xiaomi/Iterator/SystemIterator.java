package com.xiaomi.Iterator;

import java.util.ArrayList;
import java.util.List;

public class SystemIterator {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Integer>list=new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        java.util.Iterator<Integer>it=  list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    
}
