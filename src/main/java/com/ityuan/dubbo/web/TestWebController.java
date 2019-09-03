/**
 * Chengzai.com Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.ityuan.dubbo.web;

import com.ityuan.dubbo.client.ConsumerClient;
import com.ityuan.dubbo.design.chain.AbstractInterviewer;
import com.ityuan.dubbo.design.chain.Interviewee;
import com.ityuan.dubbo.rabbitmq.message.TestObjectMessage;
import com.ityuan.dubbo.rabbitmq.producer.TestProducer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ityuan
 * @version $Id: TestWebController, v 0.1 2019-02-27 19:39 ityuan Exp $
 */
@Controller
public class TestWebController implements InitializingBean {

    @Autowired
    private ConsumerClient consumerClient;

    /**
     * 组长面试官
     */
    @Autowired
    @Qualifier("teamInterviewer")
    private AbstractInterviewer teamInterviewer;

    /**
     * 经理面试官
     */
    @Autowired
    @Qualifier("managerInterviewer")
    private AbstractInterviewer managerInterviewer;
    /**
     * HR面试官
     */
    @Autowired
    @Qualifier("hrInterviewer")
    private AbstractInterviewer hrInterviewer;

    @Autowired
    private TestProducer testProducer;

    @RequestMapping("/aa")
    @ResponseBody
    public String aa(String a) {
        TestObjectMessage message = TestObjectMessage.builder()
                .name(a)
                .age(11)
                .build();
        testProducer.sendMsg(message);
        return "进来啦！";
    }

    @RequestMapping("/bb")
    @ResponseBody
    public String bb() {
        //设置面试人员
        Interviewee interviewee = new Interviewee("刘袁", true);
        //设置面试链路,组长—>经理—>人事
        teamInterviewer.setNextInterviewer(managerInterviewer);
        managerInterviewer.setNextInterviewer(hrInterviewer);
        //开始面试
        teamInterviewer.process(interviewee);
        System.out.println("刘袁".concat(teamInterviewer.toString()));
        return "bb";
    }

    @RequestMapping("/cc")
    @ResponseBody
    public String cc() {
        //设置面试人员
        Interviewee interviewee = new Interviewee("王韦", true);
        //设置面试链路,组长—>经理—>人事
        teamInterviewer.setNextInterviewer(managerInterviewer);
//        managerInterviewer.setNextInterviewer(hrInterviewer);
        //开始面试
        teamInterviewer.process(interviewee);
        System.out.println("王韦".concat(teamInterviewer.toString()));
        return "cc";
    }

    /**
     * 启动就初始化调用的方法
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
