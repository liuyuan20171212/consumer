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

    public OpenDeviceCommandImpl(Device device) {
        super(device);
    }

    @Override
    public void execute() {
        this.device.open();
    }
}
