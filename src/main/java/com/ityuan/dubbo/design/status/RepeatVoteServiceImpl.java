package com.ityuan.dubbo.design.status;

import org.springframework.stereotype.Service;

/**
 * 重复投票
 *
 * @Author ityuan
 * @Date 2019-07-02 14:04
 */
@Service
public class RepeatVoteServiceImpl implements VoteService {

    @Override
    public void vote(String params) {
        System.out.println(params.concat("重复投票！"));
    }
}
