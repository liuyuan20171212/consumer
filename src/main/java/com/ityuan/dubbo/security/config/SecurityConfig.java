package com.ityuan.dubbo.security.config;

import com.ityuan.dubbo.security.impl.AuthenticationFailureImpl;
import com.ityuan.dubbo.security.impl.AuthenticationSuccessImpl;
import com.ityuan.dubbo.security.impl.AuthenticationUserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author ityuan
 * @version SecurityConfig, v 0.1 2019/3/17 13:17
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 初始化密码加密类
     *
     * @return
     */
    @Bean("bCryptPasswordEncoder")
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    /**
     * 认证成功实现
     */
    @Autowired
    private AuthenticationSuccessImpl authenticationSuccess;

    /**
     * 认证失败实现
     */
    @Autowired
    private AuthenticationFailureImpl authenticationFailure;

    /**
     * 加密方式
     */
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 认证用户自定义接口
     */
    @Autowired
    private AuthenticationUserImpl authenticationUser;

    /**
     * 配置Spring Security 的Filter链
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
    }

    /**
     * 配置如何通过拦截器保护请求 可以对每个请求进行细粒度安全性控制
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").permitAll();
//    http.formLogin()
//        .successHandler(authenticationSuccess)
//        .failureHandler(authenticationFailure)
//        .and()
//        .httpBasic()
//        .and()
//        .authorizeRequests()
//        .antMatchers("/aa")
//        .hasAuthority("admin").and().antMatcher("/**").permitAll();
        // authenticated：允许认证过的用户访问 /aa/**
        // http.authorizeRequests().antMatchers("/aa/**").authenticated();
        // fullyAuthenticated： 如果用户是完全认证的话（不是通过Remember-me功能认证的），就允许访问
        // http.authorizeRequests().antMatchers("/bb/**").fullyAuthenticated();
        // hasAnyAuthority：如果用户具备给定权限中的某一个的话，就允许访问
        //  http.authorizeRequests().antMatchers("/cc/**").hasAnyAuthority("admin", "user");
        // hasAnyRole : 如果用户具备给定角色中的某一个的话，就允许访问
        //  http.authorizeRequests().antMatchers("/dd/**").hasAnyRole("admin", "user");
        // hasRole：如果用户具备给定角色就允许访问
        // http.authorizeRequests().antMatchers("/ee/**").hasRole("admin");
        // hasAuthority：如果用户具备给定权限就允许访问
        //  http.authorizeRequests().antMatchers("/ff/**").hasAuthority("admin");
        // hasIpAddress：如果用户具备给定IP地址的话，就允许访问
        // http.authorizeRequests().antMatchers("/gg/**").hasIpAddress("127.0.0.1");
        // 如果用户是通过 remember-me功能认证的，就允许访问
        //  http.authorizeRequests().antMatchers("/hh/**").rememberMe();
        // 无条件允许访问
        //    http.authorizeRequests().antMatchers("/aa").permitAll();
        // 需要 HTTPS 访问
        //    http.requiresChannel().antMatchers("/aa").requiresSecure();
        // 只需 HTTP 访问
        //    http.requiresChannel().antMatchers("/aa").requiresInsecure();
        // 启用记住我功能，在Cookie中存储一个Token，有效期为2419200秒，privateKey为个人私钥
        //    http.rememberMe().tokenValiditySeconds(2419200).key("privateKey");
        // 用户退出成功之后，浏览器重定向到 "/" 页面,重写默认的 LogoutFilter 拦截器路径
        //    http.logout().logoutSuccessUrl("/").logoutUrl("/signout");
    }

    /**
     * 配置user-detail服务
     *
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 引用外部接口来认证用户,并指定密码加密方式
        auth.userDetailsService(authenticationUser).passwordEncoder(bCryptPasswordEncoder);
    }
}
