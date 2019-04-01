package com.hzq.concurrency.example.commomUnsafe;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
/**
 *  SimpleDateFormat  线程不安全
 *
 *  需要写到局部变量中  每次申明一个新的  SimpleDateFormat
 */

@Slf4j
public class DateFormatExamole1 {

    private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");

    //请求总数
    public static int clientTotal=5000;
    //同时并发执行的线程数
    public static int threadTotal=200;


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
                    update();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }
    private static void update(){
        try {
            simpleDateFormat.parse("20190401");
        } catch (ParseException e) {
            log.error("parse exception",e);
        }
    }
}
