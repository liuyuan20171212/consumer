package com.ityuan.dubbo.design.observer;

import lombok.Data;

/**
 * @Author ityuan
 * @Date 2019-07-01 17:42
 */
@Data
public class FemaleFan implements Fan {

    /**
     * 名称
     */
    private String name;

    public FemaleFan() {
    }

    public FemaleFan(String name) {
        this.name = name;
    }


    @Override
    public void receiveTweets() {
        System.out.println("女性粉丝".concat(name).concat("接收推文"));
    }
}
