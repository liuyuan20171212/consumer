package com.ityuan.dubbo.rabbitmq.consumer;

import com.ityuan.dubbo.rabbitmq.constants.QueuesConstant;
import com.ityuan.dubbo.rabbitmq.message.TestObjectMessage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author ityuan
 * @Date 2019-08-02 11:36
 */

@Component
@RabbitListener(queues = QueuesConstant.QUEUE_A)
public class Test1Consumer {

    @RabbitHandler
    public void process(TestObjectMessage message) {

        System.out.println("QUEUE_A 接收处理队列A当中的消息： " + message);
    }

}
