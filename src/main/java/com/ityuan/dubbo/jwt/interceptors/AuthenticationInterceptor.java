package com.ityuan.dubbo.jwt.interceptors;


import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.ityuan.dubbo.jwt.annotations.PassToken;
import com.ityuan.dubbo.jwt.annotations.UserLoginToken;
import com.ityuan.dubbo.jwt.pojo.User;
import com.ityuan.dubbo.jwt.utils.JwtUtil;
import com.ityuan.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 获取并验证token
 *
 * @Author ityuan
 * @Date 2019-09-03 16:31
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 从 http 请求头中取出 token
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有PassToken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken loginToken = method.getAnnotation(PassToken.class);
            if (loginToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken checkToken = method.getAnnotation(UserLoginToken.class);
            if (checkToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }
                // 获取 token 中的 user id
                String userId;
                try {
                    userId = JWT.decode(token).getClaim("id").asString();
                } catch (JWTDecodeException j) {
                    throw new RuntimeException("访问异常！");
                }
                User user = userService.findUserById(userId);
                if (user == null) {
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                //token的校验
                Boolean verify = JwtUtil.isVerify(token, user);
                if (!verify) {
                    throw new RuntimeException("非法访问！");
                }
                return true;
            }
        }
        return true;
    }
}
