package com.ityuan.dubbo.design;

import com.ityuan.dubbo.design.builder.House;
import com.ityuan.dubbo.design.command.command.DeviceCommand;
import com.ityuan.dubbo.design.command.invoker.Invoker;
import com.ityuan.dubbo.design.decorator.CookDecorator;
import com.ityuan.dubbo.design.decorator.CookService;
import com.ityuan.dubbo.design.decorator.MeatDecoratorImpl;
import com.ityuan.dubbo.design.decorator.VegetableDecoratorImpl;
import com.ityuan.dubbo.design.strategy.strategy01.AbstractTaskProcessor;
import com.ityuan.dubbo.design.strategy.strategy01.TaskContextInitialization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 设计模式测试类
 *
 * @Author ityuan
 * @Date 2019-06-26 18:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DesignPatternsTest {

    @Autowired
    private TaskContextInitialization contextInitialization;
    /**
     * 实现大火烹饪
     */
    @Autowired
    @Qualifier("bigFireCookServiceImpl")
    private CookService bigFireCookServiceImpl;

    /**
     * 实现小火烹饪
     */
    @Autowired
    @Qualifier("smallFireCookServiceImpl")
    private CookService smallFireCookServiceImpl;

    /**
     * 关闭设备命令
     */
    @Autowired
    @Qualifier("closeDeviceCommandImpl")
    private DeviceCommand closeDeviceCommandImpl;

    /**
     * 打开设备命令
     */
    @Autowired
    @Qualifier("openDeviceCommandImpl")
    private DeviceCommand openDeviceCommandImpl;


    /**
     * 策略模式，有很多种实现还可以采取注解的方式实现
     */
    @Test
    public void test01() {
        AbstractTaskProcessor processor = contextInitialization.getProcessor("monday");
        System.out.println(processor.process("睡觉", "吃饭"));
    }

    /**
     * 建造者模式，产生多余的builder对象以及director对象，消耗内存
     */
    @Test
    public void test02() {
        House house = new House.HouseBuilder()
                .buildBasic("地基要稳固")
                .buildWall("墙要刷的很白")
                .buildRoof("楼顶要结实")
                .build();
        System.out.println(house.toString());
    }

    /**
     * 装饰器模式，向一个现有的对象添加新的功能，同时又不改变其结构
     */
    @Test
    public void test03() {
        CookDecorator meatDecorator = new MeatDecoratorImpl(bigFireCookServiceImpl);
        CookDecorator vegetableDecorator = new VegetableDecoratorImpl(smallFireCookServiceImpl);
        meatDecorator.cook();
        vegetableDecorator.cook();
    }

    /**
     * 命令模式：包含三个领域，命令模型，发送命令，接收命令
     * 遗留问题：如何动态设置命令接收者
     */
    @Test
    public void test04() {
        Invoker invoker1 = new Invoker(openDeviceCommandImpl);
        invoker1.call();
        Invoker invoker2 = new Invoker(closeDeviceCommandImpl);
        invoker2.call();
    }


}
