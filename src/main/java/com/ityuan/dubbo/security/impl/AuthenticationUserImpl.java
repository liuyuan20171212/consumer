package com.ityuan.dubbo.security.impl;

import com.ityuan.dubbo.security.model.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 用户认证接口实现
 *
 * @author ityuan
 * @version AuthenticationUserImpl, v 0.1 2019/3/17 13:59
 */
@Component
public class AuthenticationUserImpl implements UserDetailsService {
  @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

  /**
   * 认证用户逻辑
   *
   * @param userName
   * @return
   * @throws UsernameNotFoundException
   */
  @Override
  public UserDetail loadUserByUsername(String userName) throws UsernameNotFoundException {
    UserDetail userDetail =
        new UserDetail(
            userName,
            bCryptPasswordEncoder.encode("123456"),
            AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    userDetail.setUserId("330829831");
    userDetail.setAge(28);
    return userDetail;
  }
}
