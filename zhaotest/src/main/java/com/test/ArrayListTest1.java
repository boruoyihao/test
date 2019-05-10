package com.test;

import java.util.ArrayList;
import java.util.Date;

public class ArrayListTest1 {
   public static void main(String[] args) {
	ArrayList arraylist = new ArrayList();

    arraylist.add("hello");
    arraylist.add("world");
    arraylist.add("welcome");
  
    String s1 = (String)arraylist.get(0);
    String s2 = (String)arraylist.get(1);
    String s3 = (String)arraylist.get(2);
    
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);

    System.out.println(new Date().getTime());

  }
 }