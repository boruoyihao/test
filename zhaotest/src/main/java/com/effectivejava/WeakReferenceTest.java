package com.effectivejava;

import com.model.Student;

import java.lang.ref.WeakReference;

/**
 * Created by zhaolizhen on 17-3-4.
 */
public class WeakReferenceTest {
    public static void main(String args[]){
        Student s=new Student();
        s.setName("dd");
        WeakReference<Student> weakReference=new WeakReference<Student>(s);

        int i=0;
        while(true){
            if(weakReference.get()!=null){
                i++;
                System.out.println("Object is alive for "+i+" loops - "+weakReference.get());
            }else{
                System.out.println("Object has been collected.");
                break;
            }
        }
    }
}
