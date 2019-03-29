package com.hzq.concurrency.example.atomic;

import com.hzq.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * LongAdder
 */
@Slf4j
@ThreadSafe
public class AtomicExample3 {
    //请求总数
    public static int clientTotal=5000;
    //同时并发执行的线程数
    public static int threadTotal=200;

    public static LongAdder count=new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService=Executors.newCachedThreadPool();
        //信号量
        final Semaphore semaphore=new Semaphore(threadTotal);
        //计数器闭锁
        final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    //判断是否能执行
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                   log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}",count);
    }
    private static void add(){
        //区别： 相当 i++,++i 的区别
        count.increment();
    }

}
