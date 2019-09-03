package com.ityuan.dubbo.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 随机数配置
 *
 * @Author ityuan
 * @Date 2019-07-26 19:10
 */
@Component
@Getter
public class RandomConfig {

    @Value("${random.string}")
    private String randomString;


    @Value("${random.int}")
    private String randomInt;

    @Value("${random.long}")
    private String randomLong;

    @Value("${random.range}")
    private String randomRange;

    @Value("${random.uuid}")
    private String randomUuId;
}
