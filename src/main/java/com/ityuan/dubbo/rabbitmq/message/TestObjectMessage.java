package com.ityuan.dubbo.rabbitmq.message;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author ityuan
 * @Date 2019-08-02 15:04
 */
@Data
@Builder
public class TestObjectMessage implements Serializable {

    private static final long serialVersionUID = 779398754128963840L;

    private String name;

    private int age;

}
