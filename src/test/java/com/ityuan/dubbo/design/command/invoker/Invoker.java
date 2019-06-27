package com.ityuan.dubbo.design.command.invoker;

import com.ityuan.dubbo.design.command.command.DeviceCommand;

/**
 * 调用命令
 *
 * @Author ityuan
 * @Date 2019-06-27 19:07
 */
public class Invoker {
    /**
     * 设备命令
     */
    private DeviceCommand command;

    /**
     * 注入命令
     *
     * @param command
     */
    public Invoker(DeviceCommand command) {
        this.command = command;
    }

    /**
     * 调用命令
     */
    public void call() {
        command.execute();
    }

}
