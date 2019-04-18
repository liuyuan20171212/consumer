package com.ityuan.dubbo.security.impl;

import com.ityuan.dubbo.security.model.UserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证成功接口实现
 *
 * @author ityuan
 * @version AuthenticationSuccessImpl, v 0.1 2019/3/17 22:06
 */
@Component
public class AuthenticationSuccessImpl implements AuthenticationSuccessHandler {

  /**
   * @param request
   * @param response
   * @param authentication 可以获取到用户信息，登陆ip地址，用户sessionId
   * @throws IOException
   * @throws ServletException
   */
  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException, ServletException {
    UserDetail userDetail = (UserDetail) authentication.getPrincipal();

    System.out.println("用户信息为;" + userDetail);
  }
}
