package com.hzq.highConcurrency.example.redlock;

import org.redisson.Redisson;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * redlock  实现分布式锁
 */
public class RedLockService {

    public void RedLockTest(){

        Config config1=new Config();
        config1.useSingleServer().setAddress("127.0.0.1:6379").setPassword("root").setDatabase(0);
        RedissonClient redissonClient1=Redisson.create(config1);

        Config config2=new Config();
        config2.useSingleServer().setAddress("127.0.0.1:6379").setPassword("root").setDatabase(0);
        RedissonClient redissonClient2=Redisson.create(config1);

        Config config3=new Config();
        config3.useSingleServer().setAddress("127.0.0.1:6379").setPassword("root").setDatabase(0);
        RedissonClient redissonClient3=Redisson.create(config1);

        String resourcename="REDLOCK_KEY";
        RLock lock1 = redissonClient1.getLock(resourcename);
        RLock lock2 = redissonClient2.getLock(resourcename);
        RLock lock3 = redissonClient3.getLock(resourcename);

        //向3个redis实例同时尝试加锁
        RedissonRedLock redLock=new RedissonRedLock(lock1,lock2,lock3);

        boolean islock;

        try {
            islock = redLock.tryLock(5000, 10000, TimeUnit.MILLISECONDS);
            System.out.println("islock = " + islock);
            if (islock){
                //成功
                Thread.sleep(15000);
                System.out.println("获取锁成功 ~~~~~~~~~~~~");
            }
        }catch (Exception e){

        }finally {
            redLock.unlock();
        }
    }

    /**
     * 哨兵模式
     */
    public void sentinelTest(){
        Config config = new Config();
        config.useSentinelServers().addSentinelAddress(
                "redis://172.29.3.245:26378","redis://172.29.3.245:26379", "redis://172.29.3.245:26380")
                .setMasterName("mymaster")
                .setPassword("a123456").setDatabase(0);
    }

    /**
     * 集群模式
     */
    public void colonyTest(){
        Config config = new Config();
        config.useClusterServers().addNodeAddress(
                "redis://172.29.3.245:6375","redis://172.29.3.245:6376", "redis://172.29.3.245:6377",
                "redis://172.29.3.245:6378","redis://172.29.3.245:6379", "redis://172.29.3.245:6380")
                .setPassword("a123456").setScanInterval(5000);
    }
}
