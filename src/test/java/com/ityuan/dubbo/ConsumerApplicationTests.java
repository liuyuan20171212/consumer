package com.ityuan.dubbo;

import com.ityuan.dubbo.client.ConsumerClient;
import com.ityuan.dubbo.config.RandomConfig;
import com.ityuan.dubbo.rabbitmq.message.TestObjectMessage;
import com.ityuan.dubbo.rabbitmq.producer.TestProducer;
import com.ityuan.dubbo.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerApplicationTests {

    @Autowired
    private ConsumerClient consumerClient;

    @Autowired
    private RandomConfig randomConfig;

    @Autowired
    private TestProducer testProducer;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test04() {
//        redisTemplate.opsForValue().
    }


    @Test
    public void test03() {
        TestObjectMessage message = TestObjectMessage.builder()
                .name("q")
                .age(11)
                .build();
        testProducer.sendMsg(message);
        System.out.println("断点");
    }

    @Test
    public void test01() throws InterruptedException {
        Thread.sleep(20000);
        String result = consumerClient.getName("a");
        System.out.println(result);
    }

    @Test
    public void test02() {
        System.out.println("随机int:".concat(randomConfig.getRandomInt()));
        System.out.println("随机long:".concat(randomConfig.getRandomLong()));
        System.out.println("1-20的随机数::".concat(randomConfig.getRandomRange()));
        System.out.println("随机字符串::".concat(randomConfig.getRandomString()));
        System.out.println("uuid:".concat(randomConfig.getRandomUuId()));
    }
}
