package com.ityuan.dubbo.design.decorator;

import org.springframework.stereotype.Component;

/**
 * 小火烹饪接口实现
 *
 * @Author ityuan
 * @Date 2019-06-27 14:11
 */
@Component
public class SmallFireCookServiceImpl implements CookService {

    @Override
    public void cook() {
        System.out.println("小火烹饪！！！");
    }

}
