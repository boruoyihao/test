package com.pku.controllers;

import com.pku.model.User;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.paramresolver.ParamMetaData;
import net.paoding.rose.web.paramresolver.ParamResolver;

public class ChenBeanResolver implements ParamResolver{

    @Override
    public boolean supports(ParamMetaData metaData) {
        // TODO Auto-generated method stub
        return User.class==metaData.getParamType();
    }

    @Override
    public Object resolve(Invocation inv, ParamMetaData metaData) throws Exception {
        // TODO Auto-generated method stub
        for(String paramName:metaData.getParamNames()){
            if(paramName!=null){
                User user=new User();
                user.setAge(Integer.valueOf(inv.getParameter("age")));
                user.setName(inv.getParameter("name"));
                return user;
            };
        }
        return null;
    }

}
