package com.ityuan.dubbo.design.command.command;

import com.ityuan.dubbo.design.command.receiver.Device;
import org.springframework.stereotype.Component;

/**
 * 关闭设备的命令
 *
 * @Author ityuan
 * @Date 2019-06-27 18:07
 */
@Component
public class CloseDeviceCommandImpl extends DeviceCommand {

    public CloseDeviceCommandImpl(Device device) {
        super(device);
    }

    @Override
    public void execute() {
        this.device.close();
    }
}
