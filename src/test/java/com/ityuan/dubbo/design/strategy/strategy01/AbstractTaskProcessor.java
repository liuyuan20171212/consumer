package com.ityuan.dubbo.design.strategy.strategy01;

/**
 * @Author ityuan
 * @Date 2019-06-26 18:38
 */
public abstract class AbstractTaskProcessor {

    public abstract String process(String s1,String s2);

    public abstract String getTaskType();

}
