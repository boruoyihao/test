package com.webservice;

import com.facebook.swift.codec.ThriftConstructor;
import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftStruct;

@ThriftStruct
public class Response {
//    @ThriftConstructor
    public Response(){
        
    }
    private int id;

    @ThriftField(1)
    public int getId() {
        return id;
    }
  
    public void setId(int id) {
        this.id = id;
    }

    @ThriftField(2)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    private String content;

}
