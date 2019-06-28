package com.ityuan.dubbo.design.command.command;

import com.ityuan.dubbo.design.command.receiver.Device;

/**
 * 设备命令接口
 *
 * @Author ityuan
 * @Date 2019-06-28 14:06
 */
public interface DeviceCommandService {

    /**
     * 命令执行器
     * @param device
     */
    void execute(Device device);
}
