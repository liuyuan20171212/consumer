package com.ityuan.dubbo.design.command.receiver;

import lombok.Data;

/**
 * 灯
 *
 * @Author ityuan
 * @Date 2019-06-27 18:18
 */
@Data
public class Light extends Device {

    @Override
    public void open() {
        System.out.println("灯打开了");
    }

    @Override
    public void close() {
        System.out.println("灯关闭了");
    }
}
