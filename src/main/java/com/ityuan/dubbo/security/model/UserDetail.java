package com.ityuan.dubbo.security.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 用户信息
 *
 * @author ityuan
 * @version User, v 0.1 2019/3/17 14:01
 */
@Data
public class UserDetail extends User {

  private String userId;

  private int age;

  public UserDetail(
      String username, String password, Collection<? extends GrantedAuthority> authorities) {
    super(username, password, true, true, true, true, authorities);
  }
}
