package com.apache;

import com.google.common.collect.Sets;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhaolizhen on 17-7-11.
 */
public class MapBeanUtils {
    private static final Logger logger= LoggerFactory.getLogger(MapBeanUtils.class);

    /**
     * 把map Key value键值对转化为Bean
     * 注意bean 的类必须是public
     * @param bean
     * @param map
     */
    public static void transmap2Bean(Object bean,Map<String,Object> map){
        if(null==map||null==bean){
            logger.warn(String.format("map or bean can't be null,map:%s;bean:%s",map,bean));
            return;
        }
        try {
            BeanUtils.populate(bean,map);
        } catch (Exception e){
            logger.error(String.format("copy Map 2 Bean:%s,ERROR={}",map),e);
        }
    }

    /**
     * Bean 转换为Map,过滤掉Value为空的域
     * @param obj
     * @return
     */
    public static Map<String, Object> transBean2Map(Object obj) {
        return transBean2Map(obj, new Function() {
            @Override
            public boolean filter(String key) {
                return false;
            }
        });
    }


    public static Map<String, Object> transBean2Map(Object obj,Function f) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (key.equals("class")||f.filter(key)) {
                    continue;
                }
                // 得到property对应的getter方法
                Method getter = property.getReadMethod();
                Object value = getter.invoke(obj);
                if (value == null) {
                    continue;
                }
                map.put(key, value);
            }
        } catch (Exception e) {
            logger.error(String.format("copy bean 2 map,obj:%s,ERROR={}", obj), e);
        }
        return map;
    }

    interface Function{
        boolean filter(String key);
    }


    public static void main(String args[]){
        A a=new A();
        a.setId(12);
        a.setName("zhao");
        a.setAge("45");
        Map<String,Object>map=transBean2Map(a);
        System.out.println(map);
        Map<String,Object>map1=transBean2Map(a, new Function() {
            private final Set<String>whilteList=Sets.newHashSet("name");
            @Override
            public boolean filter(String key) {
                return !whilteList.contains(key);
            }
        });
        System.out.println(map1);
    }
}
