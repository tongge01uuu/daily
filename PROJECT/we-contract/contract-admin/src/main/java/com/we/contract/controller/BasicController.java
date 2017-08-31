package com.we.contract.controller;

import com.we.contract.domain.system.vo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Controller 父类
 * @author YK
 * @date 2017/7/17
 *
 */
@Controller
@Scope("prototype")
public class BasicController {

    protected Logger log = LoggerFactory.getLogger(getClass());


    /**
     * 登录用户名
     */
    public String getCurrentLoginName() {
        User user = getCurrentUser();
        return user.getUserLoginName();
    }

    /**
     * 登录用户对象
     */
    public User getCurrentUser() {
        Subject currentUser = SecurityUtils.getSubject();
        User user = currentUser.getPrincipals().oneByType(User.class);
        return user;
    }

}
