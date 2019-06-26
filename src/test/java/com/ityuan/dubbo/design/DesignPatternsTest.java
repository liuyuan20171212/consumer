package com.ityuan.dubbo.design;

import com.ityuan.dubbo.design.strategy.AbstractTaskProcessor;
import com.ityuan.dubbo.design.strategy.TaskContextInitialization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 设计模式测试类
 *
 * @Author ityuan
 * @Date 2019-06-26 18:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DesignPatternsTest {

    @Autowired
    private TaskContextInitialization contextInitialization;

    @Test
    public void test01() {
        AbstractTaskProcessor processor = contextInitialization.getProcessor("monday");
        System.out.println(processor.process("睡觉","吃饭"));
    }
}