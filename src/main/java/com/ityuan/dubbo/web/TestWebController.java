/**
 * Chengzai.com Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.ityuan.dubbo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ityuan.dubbo.client.ConsumerClient;

/**
 *
 * @author ityuan
 * @version $Id: TestWebController, v 0.1 2019-02-27 19:39 ityuan Exp $
 */
@Controller
public class TestWebController {
    @Autowired
    private ConsumerClient consumerClient;

    @RequestMapping("/aa")
    @ResponseBody
    public String aa(String name) {
        return name;
    }
}
