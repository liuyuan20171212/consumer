package com.ityuan.dubbo.rabbitmq.config;

import com.ityuan.dubbo.rabbitmq.constants.ExchangesConstant;
import com.ityuan.dubbo.rabbitmq.constants.QueuesConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ityuan
 * @Date 2019-08-02 17:05
 */
@Configuration
public class ExchangeBindConfig {

    @Bean
    public FanoutExchange fanoutExchange() {
        FanoutExchange exchange = new FanoutExchange(ExchangesConstant.EXCHANGE_A);
        return exchange;
    }

    @Bean("queueA")
    public Queue queueA() {
        Queue queue = new Queue(QueuesConstant.QUEUE_A, true);
        return queue;
    }

    @Bean("queueB")
    public Queue queueB() {
        Queue queue = new Queue(QueuesConstant.QUEUE_B, true);
        return queue;
    }

    @Bean("bindingA")
    public Binding bindingA() {
        return BindingBuilder.bind(queueA()).to(fanoutExchange());
    }

    @Bean("bindingB")
    public Binding bindingB() {
        return BindingBuilder.bind(queueB()).to(fanoutExchange());
    }

}
