package com.ityuan.dubbo.design.command.command;

import com.ityuan.dubbo.design.command.receiver.Device;

/**
 * 抽象设备的命令
 *
 * @Author ityuan
 * @Date 2019-06-27 18:03
 */
public abstract class DeviceCommand {

    protected Device device;

    public DeviceCommand(Device device) {
        this.device = device;
    }

    /**
     * 执行命令行为
     */
    public abstract void execute();
}
