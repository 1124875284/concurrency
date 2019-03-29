package com.hzq.concurrency;

import com.hzq.annoations.NotRecommed;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
@NotRecommed
public class ConcurrencyTest {
    //请求总数
    public static int clientTotal=5000;
    //同时并发执行的线程数
    public static int threadTotal=200;

    public static int count=0;

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
        count++;
    }

}
