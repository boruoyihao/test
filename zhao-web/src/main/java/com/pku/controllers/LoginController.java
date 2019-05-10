package com.pku.controllers;

import org.springframework.web.multipart.MultipartFile;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@Path("")
public class LoginController {

    @Get("")
    public String test(){
        return "@OK";
    }
    
    @Get("doUpload")
    public void doUpload(@Param("file") MultipartFile file){
       
    }
    
    @Get("upload")
    public String upload(Invocation inv){
        return "";
    }
}
