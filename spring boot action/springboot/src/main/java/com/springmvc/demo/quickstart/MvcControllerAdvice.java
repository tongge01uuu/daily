package com.springmvc.demo.quickstart;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yukai on 2017/6/27.
 */
@ControllerAdvice
public class MvcControllerAdvice {

    //mvc 全局异常处理器
    @ExceptionHandler
    public ModelAndView exception(Exception exception, WebRequest webRequest){
        ModelAndView modelAndView=new ModelAndView("error");
        exception.printStackTrace();
        modelAndView.addObject("message", ExceptionUtils.getStackTrace(exception));
        return modelAndView;
    }

    //全局返回对象新增属性
    @ModelAttribute
    public void addAttributes(Model model)
    {
        model.addAttribute("timestamp",System.currentTimeMillis());
        model.addAttribute("author","Michale");
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setFieldDefaultPrefix("mvc_");
        webDataBinder.setDisallowedFields("id");
    }

}
