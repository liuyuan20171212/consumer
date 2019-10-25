package com.ityuan.dubbo.service.impl;

import com.ityuan.dubbo.jwt.pojo.User;
import com.ityuan.dubbo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Author ityuan
 * @Date 2019-09-03 17:08
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * @param id
     * @return
     * @Cacheable 可以标记在一个方法上，也可以标记在一个类上，当标记在一个方法上时，表示该方法是支持缓存的。
     * 标记在一个类上时则表示该类所有的方法都支持缓存的，对于一个支持缓存的方法，Spring会在其被调用后将其返回值缓存起来。
     * 以保证下次利用同样的参数来执行改方法时可以直接从缓存中获取结果，而不需要再次执行该方法，
     * Spring在缓存方法的返回值时是以键值对进行缓存的，值就是方法的返回结果
     */
    @Override
//    @Cacheable(value = "cloud_user")
    public User findUserById(String id) {
        return new User("1", "liuyuan", "330829831");
    }

    @Override
    public List<User> findAllUsers() {
        User a = new User("1", "liuyuan", "330829831");
        User b = new User("2", "liuyuan", "330829831");
        User c = new User("3", "liuyuan", "330829831");
        System.out.println("-------------findAllUsers,数据库层面------------");
        return Arrays.asList(a, b, c);
    }

}
