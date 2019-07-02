package com.ityuan.dubbo.design.observer;

/**
 * 抽象微信公众号接口（被观察者）
 *
 * @Author ityuan
 * @Date 2019-07-01 16:40
 */
public interface WeChatPublic {
    /**
     * 添加粉丝
     */
    void addFan(Fan fan);

    /**
     * 删除粉丝
     */
    void delFan(Fan fan);

    /**
     * 发送推文
     */
    void sendTweets();
}
