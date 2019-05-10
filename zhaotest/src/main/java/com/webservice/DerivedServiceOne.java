package com.webservice;
import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;

@ThriftService
public interface DerivedServiceOne
{
    @ThriftMethod
    public  Response fooOne(Request req);
}
