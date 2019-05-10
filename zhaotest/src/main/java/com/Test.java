package com;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executors;

class SingleTonTest {
    private static SingleTonTest singleTon = new SingleTonTest();

    public static int count1;
    public static int count2 = 0;


    private SingleTonTest() {
        count1++;
        count2++;
    }

    public static SingleTonTest getInstance() {
        return singleTon;
    }
}


class AAAA{

}
public class Test {

    public static Map<String, String> parameter2Map(Map map) {
        Map<String, String> paramMap = Maps.transformEntries(map, new Maps.EntryTransformer<String, String[], String>() {
            @Override
            public String transformEntry(String key, String[] values) {
                return values[0];
            }
        });
        paramMap = Maps.filterValues(paramMap, new Predicate<String>() {
            @Override
            public boolean apply(String value) {
                return !Strings.isNullOrEmpty(value);
            }
        });
        return new TreeMap<String, String>(paramMap);
    }
    public static void main(String[] args) throws UnsupportedEncodingException {

        Executors.newCachedThreadPool();
//        System.out.println("count1=" + SingleTonTest.count1);
//        System.out.println("count2=" + SingleTonTest.count2);
//        SingleTonTest singleTon = SingleTonTest.getInstance();
//        System.out.println("count1=" + singleTon.count1);
//        System.out.println("count2=" + singleTon.count2);
//
//        String str="wget http://cs231n.stanford.edu/slides/2017/cs231n_2017_lecture{id}.pdf";
//        for(int i=1;i<=16;i++){
//            System.out.println(str.replace("{id}",i+""));
//        }
/*        ConcurrentMap<String, Object> map2 = new MapMaker()
                .weakValues().expiration(30, TimeUnit.MINUTES)
                .makeMap();*/

//        int a=1+2;
//
//        try {
//            ClassLoader.getSystemClassLoader().loadClass("SingleTonTest");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        System.out.println(Student.class.getClassLoader().getParent().getParent());
//        String str = "联通";
//        str = new String(str.getBytes("utf8"),"utf-8");
//
//        System.out.println(str);
//
//        System.out.println(URLEncoder.encode("赵立振","utf8"));

//        System.out.println(URLEncoder.encode("赵立振", "utf8"));

        String result=Joiner.on("&").withKeyValueSeparator("=").join(ImmutableMap.of("id", "123", "name", "赵立振"));
        System.out.println(result);

        Map<String,String>map=ImmutableMap.of("id", "123", "name", "赵立振");

        Map<String,String>result1=Maps.transformEntries(map, new Maps.EntryTransformer<String, String, String>() {
            @Override
            public String transformEntry(String key, String value) {

                try {
                    return URLEncoder.encode(value,"utf8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return value;
                }
            }
        });

        System.out.println(result1);
    }
}



class P{

}

class PP extends P{

}