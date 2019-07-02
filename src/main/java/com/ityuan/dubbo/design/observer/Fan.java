package com.ityuan.dubbo.design.observer;

/**
 * 抽象出公众号粉丝接口（观察者）
 *
 * @Author ityuan
 * @Date 2019-07-01 17:02
 */
public interface Fan {
    /**
     * 接收推文
     */
    void receiveTweets();
}
