package com.ityuan.dubbo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ityuan.dubbo.client.ConsumerClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerApplicationTests {
    @Autowired
    private ConsumerClient consumerClient;

    @Test
    public void test01() throws InterruptedException {
        Thread.sleep(20000);
        String result = consumerClient.getName("a");
        System.out.println(result);
    }

}
