package com.thread.threadlocal;

import java.util.Date;

/**
 * Created by zhaolizhen on 16-12-31.
 */
public class Tools {
    public static ThreadLocal<Date>t=new ThreadLocal<Date>();
    public static ThreadLocalExt<Date> t1=new ThreadLocalExt<Date>();
}
