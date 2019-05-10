package com.file;

import java.io.File;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by zhaolizhen on 16-12-4.
 */
public class FileTest {
    public static void main(String args[]){
//        String CONFIG_HOME = "/.mipay.config";
//        File HOME = new File(System.getProperty("user.home"), CONFIG_HOME);
//        HOME.mkdir();
//        System.out.print(HOME.getAbsoluteFil
        JSONObject.parseObject("{}");
        long start=System.currentTimeMillis();
        for(int i=0;i<1000;i++){
              JSONObject.parseObject("{}");
        }
        System.out.println(System.currentTimeMillis()-start);
        
    }
}
