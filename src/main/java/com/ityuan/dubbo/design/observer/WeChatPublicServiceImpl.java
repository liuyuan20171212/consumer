package com.ityuan.dubbo.design.observer;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * 被观察者实现
 * @Author ityuan
 * @Date 2019-07-01 17:28
 */
@Component
public class WeChatPublicServiceImpl implements WeChatPublic {
    /**
     * 粉丝（观察者）集合
     */
    private List<Fan> fanList;

    public WeChatPublicServiceImpl(){
        fanList =new LinkedList<Fan>();
    }

    @Override
    public void addFan(Fan fan) {
        fanList.add(fan);
    }

    @Override
    public void delFan(Fan fan) {
        fanList.remove(fan);
    }

    @Override
    public void sendTweets() {
        fanList.stream().forEach(fan -> fan.receiveTweets());
    }
}
