package com.ityuan.dubbo.design.command.command;

import com.ityuan.dubbo.design.command.receiver.Device;

/**
 * 抽象设备的命令
 *
 * @Author ityuan
 * @Date 2019-06-27 18:03
 */
public abstract class DeviceCommand implements DeviceCommandService {
    /**
     * 命令接收对象
     */
    protected Device device;

    /**
     * 执行命令行为
     */
    @Override
    public void execute(Device device) {
        //设置命令接收者
        setDevice(device);
        //处理命令
        process();
    }

    /**
     * 设置命令接收对象
     *
     * @param device
     */
    public abstract void setDevice(Device device);

    /**
     * 处理
     */
    public abstract void process();
}
