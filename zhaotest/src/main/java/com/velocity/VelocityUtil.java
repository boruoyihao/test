package com.velocity;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>velocity工具类</p>
 * @author
 * @version
 */
public class VelocityUtil {
    private static final String LOGGER_NAME = "org.apache.velocity";
    /** 引擎对象 */
    private static VelocityEngine ve = null;
    private static Logger logger= LoggerFactory.getLogger(VelocityUtil.class);

    /**
     * 获取引擎
     * @return
     */
    private static VelocityEngine loadEngine() {
        if (ve != null) {
            return ve;
        }
        synchronized (VelocityUtil.class) {
            if (ve != null) {
                return ve;
            }

            // 初始化
            VelocityEngine tempVe = new VelocityEngine();
            tempVe.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS,
                    "org.apache.velocity.runtime.log.Log4JLogChute" );
            tempVe.setProperty("runtime.log.logsystem.log4j.logger", LOGGER_NAME);
            try {
                tempVe.init();
            } catch (Exception e) {
                e.printStackTrace();
            }

            ve = tempVe;
        }

        return ve;
    }

    /**
     * 获取字数串
     * @param templateContent
     * @param paramMap
     * @return
     */
    public static String getString(String templateContent, Map<String, Object> paramMap)
                                                                                         {


        VelocityContext context = new VelocityContext();
        if (paramMap != null && paramMap.size() > 0) {
            for (Entry<String, Object> entry : paramMap.entrySet()) {
                context.put(entry.getKey(), entry.getValue());
            }
        }

        StringWriter writer = new StringWriter();
        try {
            loadEngine().evaluate(context, writer, "velocity", templateContent);

            return writer.toString();
        } catch (Exception e) {
            return null;
        }
    }








    public static void main(String[] args) {
        try {
            Map<String,Object> context = new HashMap<String, Object>();
            context.put("op",12.10);
            context.put("op1",13.23);
            String result=getString("${split10Amount}",context);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
