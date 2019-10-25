package com.ityuan.dubbo;

import com.ityuan.dubbo.jwt.pojo.User;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * Optional类
 *
 * @Author ityuan
 * @Date 2019-10-24 14:48
 */
public class OptionalTest {

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("liuyuan");
        //为非null的值创建一个Optional，注意：传入的参数不能为null，否则抛出NullPointerException异常
        Optional<User> optional1 = Optional.of(user);
        //为指定的值创建一个Optional，如果指定的值为null，则返回一个空的Optional。值可以为null
        Optional<User> optional2 = Optional.ofNullable(user);
        //返回一个空的Optional实例
        Optional optional3 = Optional.empty();
        //如果值存在返回true，否则返回false。
        boolean falg = optional3.isPresent();
        //如果Optional有值则将其返回，否则抛出NoSuchElementException。
        User user1 = optional1.get();
        //如果存在值，则使用该值调用指定的消费者，否则不执行任何操作。
        optional1.ifPresent(user2 -> {
            System.out.println("值存在哦！！");
        });
        //如果有值则将其返回，否则返回指定的其它值other。
        User user2 = optional1.orElse(new User());
        //orElseGet方法可以接受Supplier接口的实现用来生成默认值
        User user3 = optional1.orElseGet(() -> {
            User user4 = new User();
            return user4;
        });
        //值映射
        Optional<String> s = optional1.map(User::getUsername);
        Optional<User> optional = optional1.filter(user42 -> !StringUtils.equals(user42.getUsername(), "liuyuan"));
        System.out.println(optional);
    }


}
