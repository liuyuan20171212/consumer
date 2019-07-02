package com.ityuan.dubbo.design.command.command;

import com.ityuan.dubbo.design.command.receiver.Device;
import org.springframework.stereotype.Component;

/**
 * 打开设备的命令
 *
 * @Author ityuan
 * @Date 2019-06-27 18:07
 */
@Component
public class OpenDeviceCommandImpl extends DeviceCommand {

    /**
     * 设置命令接受者
     *
     * @param device
     */
    @Override
    public void setDevice(Device device) {
        super.device = device;
    }

    /**
     * 处理命令
     */
    @Override
    public void process() {
        super.device.open();
    }
}
