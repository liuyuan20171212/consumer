package com.ityuan.dubbo.jwt.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 跳过jwt验证的注解
 *
 * @Author ityuan
 * @Date 2019-09-03 16:22
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {

    boolean required() default true;

}
