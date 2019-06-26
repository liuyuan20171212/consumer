package com.ityuan.dubbo.design.strategy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ityuan
 * @Date 2019-06-26 18:47
 */
@Component
public class TaskContextInitialization implements ApplicationContextAware {
    /**
     * spring 容器
     */
    private static ApplicationContext context;
    /**
     * 容器
     */
    private final static Map<String, AbstractTaskProcessor> taskProcessorMap = new HashMap<>();

    /**
     * 得到对应的处理器
     *
     * @return
     */
    public AbstractTaskProcessor getProcessor(String s1) {
        return taskProcessorMap.get(s1);
    }

    /**
     * 初始化容器map
     */
    @PostConstruct
    public void register() {
        Map<String, AbstractTaskProcessor> taskMap = context.getBeansOfType(AbstractTaskProcessor.class);
        Collection<AbstractTaskProcessor> taskValues = taskMap.values();
        taskValues.stream().forEach(processor -> taskProcessorMap.put(processor.getTaskType(),processor));
    }


    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }
}
