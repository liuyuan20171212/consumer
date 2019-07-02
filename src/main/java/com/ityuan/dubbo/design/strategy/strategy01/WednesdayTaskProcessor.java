package com.ityuan.dubbo.design.strategy.strategy01;

import org.springframework.stereotype.Component;

/**
 * @Author ityuan
 * @Date 2019-06-26 18:45
 */
@Component
public class WednesdayTaskProcessor extends AbstractTaskProcessor {
    @Override
    public String process(String s1, String s2) {
        return "星期三该做的事情".concat(s1).concat(s2);
    }

    @Override
    public String getTaskType() {
        return "wednesday";
    }
}
