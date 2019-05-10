package com.ketangpai.filters;

import javax.servlet.*;
import java.io.IOException;
import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;
import java.util.Random;

public class StaticFilter implements Filter {
    
    private static final Logger Logger = LoggerFactory.getLogger(StaticFilter.class);
    
    private static final String SESSION_ID = "SessionId";
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Logger.debug("init方法执行");
        Properties properties = System.getProperties();
        try {
            Resource res = new ClassPathResource("app.properties");
            properties.load(res.getInputStream());
            System.setProperties(properties);
        } catch (IOException e) {
            Logger.error("Static Filter init fail:", e);
        }
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        Logger.debug("doFilter方法执行");
        HttpServletRequest servletRequest = ((HttpServletRequest) request);
        String sid = servletRequest.getSession().getId() + "_" + new Random().nextInt();
        Properties properties = System.getProperties();
        request.setAttribute("timestamp", properties.getProperty("timestamp"));
        request.setAttribute("ketangpai_mail_base", properties.getProperty("ketangpai_mail_base"));
        MDC.put(SESSION_ID, sid);
        HttpServletResponse servletResponse = ((HttpServletResponse) response);
        servletResponse.setHeader(SESSION_ID, sid);
        filterChain.doFilter(request, response);
        MDC.remove(SESSION_ID);
    }
    
    @Override
    public void destroy() {
    
    }
}
