package com.pku.controllers;

import java.util.Arrays;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pku.annotation.Filter;
import com.pku.annotation.NotBlank;
import com.pku.model.User;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.portal.Pipe;
import net.paoding.rose.web.portal.Portal;
import net.paoding.rose.web.var.Flash;

@Filter
@Path("test")
public class TestController {

   private static final Logger logger=LoggerFactory.getLogger(TestController.class);
   
    @Get("first")
    @Post("first")
    public String getFirst(Invocation inv){
        Map<String,String[]> m=inv.getRequest().getParameterMap();
        int a=0;
        for(Map.Entry<String,String[]> entry:m.entrySet()){
            logger.info("Method="+inv.getMethod()+" Test request parametres="+" "+entry.getKey()+"=="+Arrays.toString(entry.getValue()));
        }
        return "@first"+(++a);
    }
    @Get("hello")
    public String testSWebService(Invocation inv){
        int a=2/0;
        return "hello";
    }

    @Get("user")
    public String testBeanResolver(Invocation inv,User user){
        logger.info("testBeanResolver user={}",user);
        return "@User="+user.getAge()+" "+user.getName();
    }
    
    @Get("notblank")
    public String testNotblank(@NotBlank @Param("name") String name,@NotBlank @Param("age") int age){
        logger.info("testNotblank name={},age={}",name,age);
        return "@ok";
    }
    
    @Get("/flash1")
    public String flashStep1(Flash flash) {
        flash.add("msg", "修改成功！");
        return "r:flash2";
    }

    @Get("/flash2")
    public String flashStep2(Invocation inv, Flash flash) {
        inv.addModel("info", flash.get("msg"));
        return "hello";
    }
    
    @Get("3.7")
    public String portal(Portal portal) {
        portal.addWindow("p1", "wp1");
        portal.addWindow("p2", "wp2");
        return "hello";
    }

    @Get("wp1")
    public String portal1() {
        return "@this is p1";
    }

    @Get("wp2")
    public String portal2() {
        return "@this is p2";
    }
    
    @Get("3.8")
    public String pipe(Pipe pipe) {
        pipe.addWindow("p1", "wp1");
        pipe.addWindow("p2", "wp2");
        return "pipe";
    }
    

}
