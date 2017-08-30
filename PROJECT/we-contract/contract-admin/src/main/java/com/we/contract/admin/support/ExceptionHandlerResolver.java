package com.we.contract.admin.support;


import com.alibaba.fastjson.JSON;
import com.we.contract.admin.util.MsgConstants;
import com.we.contract.admin.util.ReturnData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by qibaichao on 2016/9/7.
 * 异常处理
 */
public class ExceptionHandlerResolver implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            ReturnData returnData = ReturnData.build();
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            returnData.setMessage(sw.toString());
            returnData.setStatus(MsgConstants.SYSTEM_ERROR.getCode());
            String json = JSON.toJSONString(returnData);
            assert json != null;
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}

