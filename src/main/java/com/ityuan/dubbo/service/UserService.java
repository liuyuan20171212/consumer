package com.ityuan.dubbo.service;

import com.ityuan.dubbo.jwt.pojo.User;

/**
 * @Author ityuan
 * @Date 2019-09-03 17:08
 */
public interface UserService {
    User findUserById(String id);
}
