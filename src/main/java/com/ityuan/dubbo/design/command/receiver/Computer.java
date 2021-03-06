package com.ityuan.dubbo.design.command.receiver;

import lombok.Data;

/**
 * 电脑
 *
 * @Author ityuan
 * @Date 2019-06-27 18:32
 */
@Data
public class Computer extends Device {

    @Override
    public void open() {
        System.out.println("打开电脑");
    }

    @Override
    public void close() {
        System.out.println("关闭电脑");
    }
}
