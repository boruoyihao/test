package com.pku.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.alibaba.fastjson.JSONObject;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@Path("echart")
public class EchartController {

    private String[] array={"衬衫","大衣","羽绒服","裤子","毛衣"};
    @Get("line")
    public String getLineData(Invocation inv){
        
        List<Point>list=new ArrayList<Point>();
        for(int i=0;i<15;i++){
            list.add(new Point(array[new Random().nextInt(5)]+i,new Random().nextInt(100)));
        }
        return "@"+JSONObject.toJSONString(list);
    }
    
    
    
}

class Point{
   private String name;
   private Integer data;
   public Point(String name,Integer data){
       this.name=name;
       this.data=data;
   }
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public Integer getData() {
    return data;
}
public void setData(Integer data) {
    this.data = data;
}
   
}
