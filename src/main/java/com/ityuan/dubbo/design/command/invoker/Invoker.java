package com.ityuan.dubbo.design.command.invoker;

import com.ityuan.dubbo.design.command.command.DeviceCommandService;
import com.ityuan.dubbo.design.command.receiver.Device;

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
    private DeviceCommandService command;

    /**
     * 注入命令
     *
     * @param command
     */
    public Invoker(DeviceCommandService command) {
        this.command = command;
    }

    /**
     * 调用命令
     */
    public void call(Device device) {
        command.execute(device);
    }

}
