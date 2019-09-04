package com.ityuan.dubbo.jwt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户信息 实体类支持缓存到磁盘存储，需要实现序列化接口
 *
 * @Author ityuan
 * @Date 2019-09-03 16:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -9027725949341126466L;
    private String id;
    private String username;
    private String password;
}
