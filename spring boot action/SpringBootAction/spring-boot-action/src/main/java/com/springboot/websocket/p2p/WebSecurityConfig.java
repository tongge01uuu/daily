package com.springboot.websocket.p2p;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by yukai on 2017/7/21.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    public void configure(WebSecurity web) throws Exception {
        //不拦截该目录下的静态资源
        web.ignoring().antMatchers("/resources/static/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //内存中配置两个用户已经他们的角色
        auth.inMemoryAuthentication()
                .withUser("user_1").password("pw_1").roles("USER","ADMIN").
                and()
                .withUser("user_2").password("pw_2").roles("USER","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","login").permitAll()   //不拦截的路径
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/chat") .permitAll()  //登陆成功后的跳转页面chat
                .and()
                .logout().permitAll();
    }

}
