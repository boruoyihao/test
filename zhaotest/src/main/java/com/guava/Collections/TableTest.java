package com.guava.Collections;

import com.google.common.collect.*;

/**
 * Created by zhaolizhen on 17-1-8.
 */
public class TableTest {

    public static void main(String args[]){
        Table<String,String,Integer>table= HashBasedTable.create();
        TreeBasedTable.create();
        ImmutableTable.Builder builder=ImmutableTable.builder();
        table.put("v1","b2",1);
        table.put("v1","b3",2);
        table.put("v2","b2",1);
        table.put("v3","b2",3);
        System.out.println(table.get("v1","b2"));

        System.out.println(table.row("v1"));

        System.out.println(table.column("b2"));

        Table tt=ArrayTable.create(table);
        System.out.println(tt);
    }
}
