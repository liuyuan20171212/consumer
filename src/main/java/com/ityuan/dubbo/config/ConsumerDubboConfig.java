/**
 * Chengzai.com Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.ityuan.dubbo.config;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Dubbo 消费者
 * @author ityuan
 * @version $Id: DubboConfig, v 0.1 2019-02-27 14:49 ityuan Exp $
 */
//@Configuration
//@DubboComponentScan(basePackages = "com.ityuan.dubbo.client.impl")
public class ConsumerDubboConfig {
    @Value("${dubbo.application.name}")
    private String  name;
    @Value("${dubbo.registry.address}")
    private String  address;
    @Value("${dubbo.registry.protocol}")
    private String  protocol;
    @Value("${dubbo.protocol.name}")
    private String  protocolName;
    @Value("${dubbo.protocol.port}")
    private Integer port;

    /**
     * 当前应用配置
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig application = new ApplicationConfig();
        application.setName(name);
        return application;
    }

    /**
     * 连接注册中心配置
     * @return
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress(address);
        registry.setProtocol(protocol);
        return registry;
    }

    /**
     * 消费者配置
     * 也可用 ConsumerConfig
     * @return
     */
    @Bean
    public ConsumerConfig referenceConfig(ApplicationConfig applicationConfig,
                                          RegistryConfig registryConfig) {
        ConsumerConfig reference = new ConsumerConfig();
        reference.setApplication(applicationConfig);
        /**
         * 多个注册中心可以用setRegistries()
         */
        reference.setRegistry(registryConfig);
        return reference;
    }

}
