package com.we.contract.architect.realm;

import com.we.contract.entity.system.vo.Resource;
import com.we.contract.entity.system.vo.User;
import com.we.contract.service.system.ResourceService;
import com.we.contract.service.system.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


/**
 * 自定义Realm 实现Shiro权限验证
 *
 * @author YK
 * @date 2017/7/10
 */
@Component
public class ShiroDbRealm extends AuthorizingRealm {

    private Logger log = LoggerFactory.getLogger(ShiroDbRealm.class);

    @Autowired
    @Lazy
    private UserService userService;
    @Autowired
    @Lazy
    private ResourceService resourceService;

    /**
     * 获取认证信息
     *
     * @return
     * @throws AuthenticationException
     */

    @Bean(name = "credentialsMatcher")
    public CredentialsMatcher credentialsMatcher()
    {
        CredentialsMatcher credentialsMatcher=new SimpleCredentialsMatcher();
        return credentialsMatcher;
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        String username = userToken.getUsername();
        if (StringUtils.isEmpty(username)) {
            log.error("获取认证信息失败，原因:用户名为空");
            throw new AccountException("用户名为空");
        }
        // 根据登陆用户名查询用户信息
        User user = userService.selectUserByloginName(username);
        if (user == null) {
            throw new AccountException("用户信息为空");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getUserPassword(), getName());
        if (null != info) {
            log.info("用户认证通过:登陆用户名:" + user.getUserLoginName());
            return info;
        }
        return null;
    }


    /**
     * 获取授权信息
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthorizationException("Principal对象不能为空");
        }

        User user = (User) getAvailablePrincipal(principals);
        log.info("加载用户权限信息，当前登陆用户名:" + user.getUserLoginName());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Resource res = resourceService.selectByPrimaryKey(2);
        info.addStringPermission(res.getResModelCode());
        return  info;
    }
}
