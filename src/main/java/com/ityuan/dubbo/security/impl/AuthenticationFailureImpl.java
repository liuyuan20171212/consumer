package com.ityuan.dubbo.security.impl;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆失败处理器
 *
 * @author ityuan
 * @version AuthenticationFailImpl, v 0.1 2019/3/17 22:17
 */
@Component
public class AuthenticationFailureImpl implements AuthenticationFailureHandler {
  /**
   * @param request
   * @param response
   * @param e 可以对该异常进行细分
   * @throws IOException
   * @throws ServletException
   */
  @Override
  public void onAuthenticationFailure(
      HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
      throws IOException, ServletException {}
}
