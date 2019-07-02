package com.ityuan.dubbo.design.chain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 组长面试官
 *
 * @Author ityuan
 * @Date 2019-06-28 15:26
 */
@Component
@Scope("prototype")
public class TeamInterviewer extends AbstractInterviewer {

    @Override
    public void audition(Interviewee interviewee) {
        System.out.println("组长面试".concat(interviewee.getName()));

    }
}
