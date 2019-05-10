package com.webservice;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class WebServiceTest {
    @WebMethod  
    public String hello(String name) {   
    return "Hello, " + name + "\n";   
    }   
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WebServiceTest webServiceTest=new WebServiceTest();
        Endpoint endpoint = Endpoint.publish("http://localhost:8080/hello", webServiceTest);
    }
    
}
