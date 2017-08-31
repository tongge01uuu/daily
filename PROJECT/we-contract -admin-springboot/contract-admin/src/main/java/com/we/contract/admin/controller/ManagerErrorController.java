package com.we.contract.admin.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * 错误页面Controller <br>
 * 用于解决当 页面加载静态资源404时，拦截器报空指针问题
 * @author YK
 * @date 2017/7/27
 */

@Controller
public class ManagerErrorController extends BasicController implements ErrorController {
    private static final String ERROR_PATH = "/error";
    @RequestMapping(value=ERROR_PATH)
    public String handleError(){
        return "error/404";
    }
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
