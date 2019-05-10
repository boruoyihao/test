package com.apache;




import org.apache.commons.beanutils.BeanUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaolizhen on 17-2-27.
 */
public class utils {
    public static void main(String args[]){
        A a=new A();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id",1);
        map.put("name","zhao");
        try {
            BeanUtils.populate(a,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(a);
    }

    private static void transMap2Bean(Map<String, Object> map, Object obj) {
        if (null == map) {
            return;
        }
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
//                String key= CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE,property.getName());
                String key=property.getName();
                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    Method setter = property.getWriteMethod();
                    setter.invoke(obj, getTargetValue(property.getPropertyType(),property.getName(),value));
                }
            }
        } catch (Exception e) {
        }
        return;
    }

    private static <T> T getTargetValue(Class<T> cls,String fieldName,Object value){
        if(cls.equals(value.getClass())){
            return (T)value;
        }else if(cls==String.class){
            return (T)value.toString();
        }else if(cls==Date.class){
            return (T)new Date(System.currentTimeMillis());  //临时写死
        }
        return (T)value;
    }

    public static Map<String, Object> transBean2Map(Object obj) {

        if(obj == null){
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);

                    map.put(key, value);
                }

            }
        } catch (Exception e) {
            System.out.println("transBean2Map Error " + e);
        }
        return map;

    }

}

