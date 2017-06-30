package com.springmvc.demo.quickstart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yukai on 2017/6/27.
 */
public class MvcInterceptorExtendsAdapter extends HandlerInterceptorAdapter{
    private final static Logger logger= LoggerFactory.getLogger(MvcInterceptorExtendsAdapter.class);
    public final static String beginTimeKey="beginTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long beginTime=System.currentTimeMillis();
        request.setAttribute(beginTimeKey,beginTime);

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long beginTime=Long.parseLong(request.getAttribute(beginTimeKey).toString());
        long endTime=System.currentTimeMillis();

        logger.info(String.format("------- URL: %s EXECUTE TIME: %S ms",request.getRequestURI(),(endTime-beginTime)));
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
