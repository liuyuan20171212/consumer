package com.ityuan.dubbo.design.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 状态设计模式——投票系统
 * 正常投票：一人一票
 * 反复投票：一人多票但小于5票
 * 黑名单票：一人多票但大于5票
 *
 * @Author ityuan
 * @Date 2019-07-02 13:58
 */
@Component
public class VoteManager {

    @Autowired
    private Map<String, VoteService> voteMap;

    /**
     * 开始投票
     *
     * @param params
     */
    public void startVote(String params,VoteEnum voteEnum) {
        VoteService voteService = voteMap.get(voteEnum.getImplement());
        voteService.vote(params);
    }


}
