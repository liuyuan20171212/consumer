package com.ityuan.dubbo.jwt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息
 *
 * @Author ityuan
 * @Date 2019-09-03 16:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String username;
    private String password;
}
