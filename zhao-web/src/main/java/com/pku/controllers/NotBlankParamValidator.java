package com.pku.controllers;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;

import com.pku.annotation.NotBlank;
import com.pku.model.User;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.ParamValidator;
import net.paoding.rose.web.paramresolver.ParamMetaData;

public class NotBlankParamValidator implements ParamValidator{

    private static final Logger logger=LoggerFactory.getLogger(NotBlankParamValidator.class);
    @Override
    public boolean supports(ParamMetaData metaData) {
        // TODO Auto-generated method stub
        return metaData.getAnnotation(NotBlank.class) != null;
    }

    @Override
    public Object validate(ParamMetaData metaData, Invocation inv, Object target, Errors errors) {
        // TODO Auto-generated method stub
        String params[]=metaData.getParamNames();
        for(String p:params){
            logger.info("key={},value={}",p,inv.getParameter(p));
        }
        String paramName = metaData.getParamName();
        String value = inv.getParameter(paramName);
        if (StringUtils.isBlank(value)) {
            return "@参数不能为空";
        }
        return null;
    }

}
