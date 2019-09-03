package com.ityuan.dubbo.rabbitmq.producer;

import com.ityuan.dubbo.rabbitmq.constants.ExchangesConstant;
import com.ityuan.dubbo.rabbitmq.message.TestObjectMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 测试消息的生产者
 *
 * @Author ityuan
 * @Date 2019-08-02 11:02
 */
@Component
public class TestProducer implements RabbitTemplate.ConfirmCallback {
    /**
     * 由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
     */
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public TestProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
        rabbitTemplate.setConfirmCallback(this);
    }

    public void sendMsg(TestObjectMessage message) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
        rabbitTemplate.convertAndSend(ExchangesConstant.EXCHANGE_A, null, message, correlationId);
    }

    /**
     * 回调
     *
     * @param correlationData
     * @param b
     * @param s
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println("回调id".concat(":") + correlationData);
        if (b) {
            System.out.println("消息消费成功！！！" + s);
        } else {
            System.out.println("消息消费失败！！！！" + s);

        }

    }
}
