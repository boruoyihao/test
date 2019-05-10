package com.velocity;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaolizhen on 17-2-15.
 */
public class VelocityTest {

    private static VelocityEngine ve=new VelocityEngine();


    public static void main(String args[]) throws Exception {
        ve.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS,
                "org.apache.velocity.runtime.log.Log4JLogChute" );
        ve.setProperty("runtime.log.logsystem.log4j.logger", "velocity");
        ve.init();
        VelocityContext context = new VelocityContext();
        context.put("op",12.10);
        context.put("op1",13.23);
        context.put("temp",23);
        StringWriter writer = new StringWriter();
        String expresison="${split10Amount}";


//            ve.evaluate(context,writer,"velocity","#if(!${op})12.3 #else${op} #end");
//            ve.evaluate(context,writer,"velocity","#if(!$op1)$op1#end");
//                        ve.evaluate(context,writer,"velocity","${op1}");
//            System.out.println(ve.);

///            ve.evaluate(context,writer,"velocity","#if(${op1})+${op1}#end");
//            ve.evaluate(context,writer,"velocity","#$sum=''if(${op1})sum=sum+${op1}#end #set($temp=$op)$temp");

//            ve.evaluate(context,writer,"velocity","#set($sum='')#if(${op1})sum=sum+${op1}#end #set($temp=$op+$sum)$temp");
//            ve.evaluate(context,writer,"velocity","#set($temp=$op+$!op1)$temp");
//            ve.evaluate(context,writer,"velocity","#set($sum=0)#if(${op})#set($sum=${sum}+${op})#end#if(${op1})#set($sum=${sum}+${op1})#end$sum");
//            ve.evaluate(context,writer,"velocity","#set($temp=${op}+${op1})$temp");
//            ve.evaluate(context,writer,"velocity",expresison);
        ve.evaluate(context,writer,"velocity","$temp");

        System.out.println(expresison.equals(writer.toString()));
        System.out.println(StringUtils.equals(expresison,writer.toString()));
        System.out.println(writer.toString().trim());

    }

}
