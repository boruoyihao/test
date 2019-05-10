package com.guava.string;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhaolizhen on 17-1-10.
 */
public class JoinerTest {
    private static Joiner joiner=Joiner.on("_").useForNull("*");
    public static void main(String args[]){
        System.out.println(joiner.join("12","34","56",null));
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "CONSTANT_NAME"));
        System.out.println(CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE,"aaDd"));
        System.out.println(CharMatcher.DIGIT.retainFrom("dd123tt"));
        System.out.println(CharMatcher.DIGIT.or(CharMatcher.JAVA_LOWER_CASE).or(CharMatcher.JAVA_UPPER_CASE).retainFrom("  ddeee123fdddDDD"));

        System.out.println();

        net.sf.json.JSONObject jsonObject=new JSONObject();
        jsonObject.put("date",new Date());
        System.out.println(new Date(System.currentTimeMillis()-24*3600*365*1000));
//        System.out.println(jsonObject.getString("date"));
//        JsonConfig config = new JsonConfig();
//        config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("G yyyy-MM-dd hh:mm:ss.SS zzz ZZZ w DDD FF EE"));
//        System.out.println(new Date(String.valueOf(JSONObject.fromObject(jsonObject, config))));

    }
}



 class DateJsonValueProcessor implements JsonValueProcessor {
    /**
     * 字母 日期或时间元素 表示 示例 <br>
     * G Era 标志符 Text AD <br>
     * y 年 Year 1996; 96 <br>
     * M 年中的月份 Month July; Jul; 07 <br>
     * w 年中的周数 Number 27 <br>
     * W 月份中的周数 Number 2 <br>
     * D 年中的天数 Number 189 <br>
     * d 月份中的天数 Number 10 <br>
     * F 月份中的星期 Number 2 <br>
     * E 星期中的天数 Text Tuesday; Tue<br>
     * a Am/pm 标记 Text PM <br>
     * H 一天中的小时数（0-23） Number 0 <br>
     * k 一天中的小时数（1-24） Number 24<br>
     * K am/pm 中的小时数（0-11） Number 0 <br>
     * h am/pm 中的小时数（1-12） Number 12 <br>
     * m 小时中的分钟数 Number 30 <br>
     * s 分钟中的秒数 Number 55 <br>
     * S 毫秒数 Number 978 <br>
     * z 时区 General time zone Pacific Standard Time; PST; GMT-08:00 <br>
     * Z 时区 RFC 822 time zone -0800 <br>
     */
    public static final String Default_DATE_PATTERN = "yyyy-MM-dd";
    private DateFormat dateFormat;

    public DateJsonValueProcessor(String datePattern) {
        try {
            dateFormat = new SimpleDateFormat(datePattern);
        } catch (Exception e) {
            dateFormat = new SimpleDateFormat(Default_DATE_PATTERN);
        }
    }

    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        return process(value);
    }

    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
        return process(value);
    }

    private Object process(Object value) {
        return dateFormat.format((Date) value);

    }
}
