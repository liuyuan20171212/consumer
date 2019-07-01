package com.ityuan.dubbo.design.chain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 经理面试官
 * @Author ityuan
 * @Date 2019-06-28 15:28
 */
@Component
@Scope("prototype")
public class ManagerInterviewer extends AbstractInterviewer {

    @Override
    public void audition(Interviewee interviewee) {

        System.out.println("经理面试".concat(interviewee.getName()));
    }
}
