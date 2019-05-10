package com.map;


import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaolizhen on 16-12-9.
 */
public class MapTest {
    public static void main(String args[]){
        Map<String,PP>m=new HashMap<String, PP>();
        m.put("dd",null);
        PP pp=m.get("dd");
        m.put("dd",new PP(1,"dd"));
        System.out.println(pp);
//        m.put("ddd",new PP(1,"zhaolizhen"));
//        PP value=m.get("ddd");
//        value.setAge(3);
//        value.setName("ddddddddddddd");
//        System.out.println(m.get("ddd"));
    }

    static class PP{
        private int age;
        private String name;

        public PP(int age,String name){
            this.age=age;
            this.name=name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "PP{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


    static void getValue(){
        Map<String,String> config= Maps.newHashMap();
        try{
            config= JSONObject.parseObject("", Map.class);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("config"+config.containsKey("dd"));
    }
}
