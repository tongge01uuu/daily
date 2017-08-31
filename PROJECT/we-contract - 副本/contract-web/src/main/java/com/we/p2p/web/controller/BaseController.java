package com.we.p2p.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.bean.enums.ResultStatus;
import com.site.bean.resultBean.Result;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Created by Mr-Wu on 2016/5/16.
 */
public class BaseController {

    public static final String EXP_MSG = "%s occurred exception.";

    /**
     * 服务方法返回正常判断
     * @param result
     * @return
     */
    public boolean isSuccess(Result result){
       return (null != result && result.getStatus() == ResultStatus.SUCCESS);
    }

    /**
     * 服务方法返回异常判断
     * @param result
     * @return
     */
    public boolean isReturnFail(Result result){
        return (!isSuccess(result));
    }
    public void setSessionAttr(String key, Object obj) {
        HttpServletRequest request = getHttpServletRequest();
        request.getSession().setAttribute(key, obj);
    }

    public Object getSessionAttr(String key) {
        HttpServletRequest request = getHttpServletRequest();
        return request.getSession().getAttribute(key);
    }

    public void setReqAttr(String key, Object obj) {
        HttpServletRequest request = getHttpServletRequest();
        request.setAttribute(key, obj);
    }

    public Object getReqAttr(String key) {
        HttpServletRequest request = getHttpServletRequest();
        return request.getAttribute(key);
    }

    public void cleanCache() {
        HttpServletResponse response = getHttpServletResponse();
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
        response.setCharacterEncoding("UTF-8");
    }

    protected HttpServletRequest getHttpServletRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return request;
    }

    protected HttpServletResponse getHttpServletResponse() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getResponse();
        return response;
    }
}
