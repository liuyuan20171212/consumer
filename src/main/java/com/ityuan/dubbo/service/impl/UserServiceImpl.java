package com.ityuan.dubbo.service.impl;

import com.ityuan.dubbo.jwt.pojo.User;
import com.ityuan.dubbo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author ityuan
 * @Date 2019-09-03 17:08
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findUserById(String id) {
        return new User("1", "liuyuan", "330829831");
    }
}
