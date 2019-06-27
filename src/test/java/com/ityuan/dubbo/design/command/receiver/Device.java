package com.ityuan.dubbo.design.command.receiver;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 设备，命令模式中的执行者
 *
 * @Author ityuan
 * @Date 2019-06-27 18:24
 */
@Data
@Component
public class Device {
    /**
     * 品牌
     */
    private String brand;
    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 打开设备
     */
    public void open() {
        System.out.println("打开设备");
    }

    /**
     * 关闭设备
     */
    public void close() {
        System.out.println("关闭设备");
    }

}
