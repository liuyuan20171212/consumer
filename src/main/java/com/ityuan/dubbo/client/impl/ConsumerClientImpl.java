/**
 * Chengzai.com Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.ityuan.dubbo.client.impl;

import org.springframework.stereotype.Service;

import com.ityuan.dubbo.client.ConsumerClient;

/**
 *
 * @author ityuan
 * @version $Id: ConsumerClientImpl, v 0.1 2019-02-27 11:53 ityuan Exp $
 */
@Service
public class ConsumerClientImpl implements ConsumerClient {

//    @Reference(version = "1.0.0",check = false)

    @Override
    public String getName(String a) {
//        String s = testManagerService.test01(a);
        return "哈根达斯";
    }
}
