
package com.we.contract.architect.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义拦截器
 * @author YK
 * @date 2017/7/26.
 */
//@Component
public class MyWebFilter implements Filter {
    private Logger log = LoggerFactory.getLogger(MyWebFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        log.info("==>拦截请求"+response.getStatus());
        log.info(((HttpServletRequest) req).getRequestURL().toString());
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
