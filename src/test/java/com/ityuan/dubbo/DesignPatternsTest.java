package com.ityuan.dubbo;

import com.ityuan.dubbo.design.builder.House;
import com.ityuan.dubbo.design.chain.AbstractInterviewer;
import com.ityuan.dubbo.design.chain.Interviewee;
import com.ityuan.dubbo.design.command.command.DeviceCommandService;
import com.ityuan.dubbo.design.command.invoker.Invoker;
import com.ityuan.dubbo.design.command.receiver.Computer;
import com.ityuan.dubbo.design.command.receiver.Light;
import com.ityuan.dubbo.design.decorator.CookDecorator;
import com.ityuan.dubbo.design.decorator.CookService;
import com.ityuan.dubbo.design.decorator.MeatDecoratorImpl;
import com.ityuan.dubbo.design.decorator.VegetableDecoratorImpl;
import com.ityuan.dubbo.design.observer.Fan;
import com.ityuan.dubbo.design.observer.FemaleFan;
import com.ityuan.dubbo.design.observer.MaleFan;
import com.ityuan.dubbo.design.observer.WeChatPublic;
import com.ityuan.dubbo.design.status.VoteEnum;
import com.ityuan.dubbo.design.status.VoteManager;
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
    private DeviceCommandService closeDeviceCommandImpl;

    /**
     * 打开设备命令
     */
    @Autowired
    @Qualifier("openDeviceCommandImpl")
    private DeviceCommandService openDeviceCommandImpl;
    /**
     * 组长面试官
     */
    @Autowired
    @Qualifier("teamInterviewer")
    private AbstractInterviewer teamInterviewer;

    /**
     * 经理面试官
     */
    @Autowired
    @Qualifier("managerInterviewer")
    private AbstractInterviewer managerInterviewer;
    /**
     * HR面试官
     */
    @Autowired
    @Qualifier("hrInterviewer")
    private AbstractInterviewer hrInterviewer;
    /**
     * 观察者模式
     */
    @Autowired
    private WeChatPublic weChatPublic;
    /**
     * 状态设计模式之投票
     */
    @Autowired
    private VoteManager voteManager;

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
     * 命令模式：包含三个领域，命令模型，发送命令模型，接收处理命令模型
     */
    @Test
    public void test04() {
        Invoker invoker1 = new Invoker(openDeviceCommandImpl);
        invoker1.call(new Light());
        Invoker invoker2 = new Invoker(closeDeviceCommandImpl);
        invoker2.call(new Computer());
    }

    /**
     * 责任链模式：同一任务多角色完成，多样化且动态的决定任务完成的传递链即责任链
     */
    @Test
    public void test05() {
        //设置面试人员
        Interviewee interviewee = new Interviewee("刘袁", true);
        //设置面试链路,组长—>经理—>人事
        teamInterviewer.setNextInterviewer(managerInterviewer);
        managerInterviewer.setNextInterviewer(hrInterviewer);
        //开始面试
        teamInterviewer.process(interviewee);
        System.out.println("刘袁".concat(teamInterviewer.toString()));
    }

    /**
     * 观察者模式：定义对象间一种一对多的依赖关系，使得每当一个对象改变状态，则所有依赖于它的对象都会得到通知并被自动更新
     * 案例：微信公众号不定时发布一些消息，关注公众号就可以收到推送消息，取消关注就收不到推送消息。
     */
    @Test
    public void test06() {
        Fan f1 = new FemaleFan("王韦");
        Fan f2 = new MaleFan("刘袁");
        //添加粉丝
        weChatPublic.addFan(f1);
        weChatPublic.addFan(f2);
        //发送公众号推文
        weChatPublic.sendTweets();
    }

    /**
     * 状态设计模式：状态模式允许对象在内部状态改变时改变它的行为，对象看起来好像改变了它的类
     * 关键点：对象内部改变其状态，可动态改变其行为。
     *
     */
    @Test
    public void test07() {
        voteManager.startVote("刘袁", VoteEnum.BLACKLIST);
    }

}
