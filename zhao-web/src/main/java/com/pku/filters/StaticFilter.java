package com.pku.filters;

import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;


public class StaticFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(StaticFilter.class);

    private static final String SESSION_ID = "SessionId";


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Properties properties = System.getProperties();
        try {
            Resource res = new ClassPathResource("app.properties");
            properties.load(res.getInputStream());
            System.setProperties(properties);
        } catch (IOException e) {
            LOGGER.error("Static Filter init fail:", e);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servletRequest = ((HttpServletRequest) request);
        String sid = servletRequest.getSession().getId() + "_" + Long.toString(System.currentTimeMillis(), 10);
        Properties properties = System.getProperties();
        request.setAttribute("zhao-web", properties.getProperty("direnjie_base"));
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
