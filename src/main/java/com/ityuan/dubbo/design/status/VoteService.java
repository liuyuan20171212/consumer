package com.ityuan.dubbo.design.status;

/**
 * 投票服务
 *
 * @Author ityuan
 * @Date 2019-07-02 14:04
 */
public interface VoteService {
    /**
     * 投票
     */
    void vote(String params);
}
