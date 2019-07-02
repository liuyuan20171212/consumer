package com.ityuan.dubbo.design.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author ityuan
 * @Date 2019-07-02 14:20
 */
@Getter
@AllArgsConstructor
public enum VoteEnum {
    NORMAL("normal", "正常投票", "normalVoteServiceImpl"),
    REPEAT("repeat", "重复投票", "repeatVoteServiceImpl"),
    BLACKLIST("blacklist", "黑名单", "blackListVoteServiceImpl"),
    ;
    private String code;
    private String desc;
    private String implement;
}
