package com.ityuan.dubbo.web;

import com.ityuan.dubbo.jwt.annotations.PassToken;
import com.ityuan.dubbo.jwt.annotations.UserLoginToken;
import com.ityuan.dubbo.jwt.pojo.User;
import com.ityuan.dubbo.jwt.utils.JwtUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author ityuan
 * @Date 2019-09-03 17:15
 */
@RestController
public class JwtController {


    @RequestMapping("/jwt")
    @UserLoginToken
    public String jwt() {
        return "访问jwt成功";
    }

    @RequestMapping("/jwt/login")
    @PassToken
    public Object login() {
        String token = JwtUtil.createJWT(DateUtils.addHours(new Date(), 5).getTime(), new User("1", "liuyuan", "330829831"));
        return token;
    }
}
