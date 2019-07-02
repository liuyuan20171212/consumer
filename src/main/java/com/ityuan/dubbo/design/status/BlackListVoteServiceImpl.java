package com.ityuan.dubbo.design.status;

import org.springframework.stereotype.Service;

/**
 * 黑名单投票
 *
 * @Author ityuan
 * @Date 2019-07-02 14:04
 */
@Service
public class BlackListVoteServiceImpl implements VoteService {

    @Override
    public void vote(String params) {
        System.out.println(params.concat("黑名单投票！"));
    }
}
