package com.demo.filter;


import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

public class Filter1 implements Filter{

    private static final Logger logger= Logger.getLogger(Filter1.class);

    public void init(FilterConfig filterConfig) throws ServletException {

        logger.debug("init");

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        logger.debug("doFilter");
        filterChain.doFilter(servletRequest,servletResponse);

        logger.debug("after filterChain.doFilter");


    }

    public void destroy() {
        logger.debug("destroy");
    }
}
