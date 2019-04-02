package com.hzq.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch
 */
@Slf4j
public class CountDownLatchExample1 {

    private final static int threadCount=200;
    public static void main(String[] args) throws Exception{
        ExecutorService executorService=Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch=new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            Thread.sleep(100);
            final int threadNum=i;
            executorService.execute(()->{
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    log.error("异常");
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        //等countDown()减到0  才会执行await()
        countDownLatch.await();
        log.info("finish");
        executorService.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {

        log.info("{}",threadNum);
    }
}
