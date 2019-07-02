package com.ityuan.dubbo.design.chain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Hr 面试官
 *
 * @Author ityuan
 * @Date 2019-06-28 15:29
 */
@Component
@Scope("prototype")
public class HrInterviewer extends AbstractInterviewer {

    @Override
    public void audition(Interviewee interviewee) {
        System.out.println("HR面试官".concat(interviewee.getName()));
    }
}
