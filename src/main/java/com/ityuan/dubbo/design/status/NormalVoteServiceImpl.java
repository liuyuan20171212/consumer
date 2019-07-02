package com.ityuan.dubbo.design.status;

import org.springframework.stereotype.Service;

/**
 * 正常投票
 *
 * @Author ityuan
 * @Date 2019-07-02 14:04
 */
@Service
public class NormalVoteServiceImpl implements VoteService {
    
    @Override
    public void vote(String params) {
        System.out.println(params.concat("正常投票！"));
    }
}
