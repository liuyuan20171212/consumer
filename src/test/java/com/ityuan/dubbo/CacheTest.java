package com.ityuan.dubbo;


import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @Author ityuan
 * @Date 2019-09-10 11:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {

    public static void main(String[] args) {
        Config config1 = new Config();
        config1.useSingleServer()
                .setAddress("redis://127.0.0.1:6379");
        RedissonClient redissonClient1 = Redisson.create(config1);
        Config config2 = new Config();
        config2.useSingleServer()
                .setAddress("redis://redis01.grr6uh.0001.cnw1.cache.amazonaws.com.cn:6379");
        RedissonClient redissonClient2 = Redisson.create(config2);
        RLock lock1 = redissonClient1.getLock("lock1");
        RLock lock2 = redissonClient2.getLock("lock2");
        RedissonRedLock redissonRedLock = new RedissonRedLock(lock1, lock2);
        redissonRedLock.lock(10, TimeUnit.SECONDS);
        redissonRedLock.unlock();
        System.out.println("end");
    }

}
