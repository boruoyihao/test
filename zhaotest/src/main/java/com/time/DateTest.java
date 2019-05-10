package com.time;

import org.apache.commons.lang.time.DateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhaolizhen on 17-5-22.
 */
public class DateTest {
    public static void main(String args[]){
//        System.out.println(new Date(System.currentTimeMillis()-24*3600*1000));
//        Map<String,String> m=new ConcurrentHashMap();
//        System.out.println(DateUtils.isSameDay(new Date(),new Date(System.currentTimeMillis()-16*3600*1000)));

        System.out.println(getDiffMinutes(new Date(),new Date(System.currentTimeMillis()-1000*60*60*2)));
    }

    public static long getDiffMinutes(Date one, Date two) {
        Calendar sysDate = new GregorianCalendar();

        sysDate.setTime(one);

        Calendar failDate = new GregorianCalendar();

        failDate.setTime(two);
        return (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) / (60 * 1000);
    }
}
