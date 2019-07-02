package com.ityuan.dubbo.design.observer;

import lombok.Data;

/**
 * @Author ityuan
 * @Date 2019-07-01 17:41
 */
@Data
public class MaleFan implements Fan {
    /**
     * 名称
     */
    private String name;

    public MaleFan() {
    }

    public MaleFan(String name) {
        this.name = name;
    }


    @Override
    public void receiveTweets() {
        System.out.println("男性粉丝".concat(name).concat("接收推文"));
    }
}
