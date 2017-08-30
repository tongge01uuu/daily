package com.we.contract.admin.controller;

import com.alibaba.fastjson.JSON;
import com.we.contract.admin.architect.constant.BussinessCode;
import com.we.contract.admin.architect.constant.Constants;
import com.we.contract.admin.architect.utils.BussinessMsgUtil;
import com.we.contract.admin.domain.system.bo.ResultEntity;
import com.we.contract.entity.BankSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆Controller
 * @author YK
 * @date 2017/7/17
 *
 */
@Controller
public class LoginController extends BasicController {

    /**
     * 登陆代理，跳转到顶级父窗口
     **/
    @RequestMapping("/loginProxy.do")
    public String toLoginProxy() {

        log.info(JSON.toJSONString(new BankSupport()));
        return "main/loginProxy";
    }



    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping("/login.do")
    public String toLoginPage() {
        return "login";
    }

    /**
     *  登录验证处理
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping("/loginCheck.do")
    @ResponseBody
    public ResultEntity loginCheck(String username, String password, HttpServletRequest request){
        log.info("登陆验证处理开始");
        long start = System.currentTimeMillis();
        try {
            //1.用户名不能为空
            if (StringUtils.isEmpty(username)) {
                log.error("登陆验证失败,原因:用户名不能为空");
                return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_NAME_NULL);
            }
            //2.密码不能为空
            if (StringUtils.isEmpty(password)) {
                log.error("登陆验证失败,原因:密码不能为空");
                return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_PASS_NULL);
            }
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            Subject currentUser = SecurityUtils.getSubject();

            currentUser.login(token);
            if (currentUser.isAuthenticated()) {
                request.getSession().setAttribute(Constants.SESSION_KEY_LOGIN_NAME,getCurrentUser());

                return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_SUCCESS);
            }
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_FAIL);
        } catch (IncorrectCredentialsException ice) {
            log.error("登陆验证失败,原因:用户名或密码不匹配");
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_FAIL);
        }catch (AccountException e){
            log.error("登陆验证失败,原因:用户名或密码不匹配");
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_FAIL);
        }catch (Exception e) {
            log.error("登陆验证失败,原因:系统登陆异常", e);
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_ERROR);
        } finally {
            log.info("登陆验证处理结束,用时" + (System.currentTimeMillis() - start) + "毫秒");
        }

    }

    /**
     * 用户退出
     */
    @RequestMapping("/logout.do")
    public String logout(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "login";

    }





}
