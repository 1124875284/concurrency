package com.hzq.concurrency.example.syncContainer;

import com.hzq.annoations.NotThreadSafe;
import com.hzq.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Vector 在某些情况下会存在线程不安全
 */
@Slf4j
@NotThreadSafe
public class VectorExample2 {

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        Thread thread1 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    vector.remove(i);
                }
            }
        };
        Thread thread2 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    vector.get(i);
                }
            }
        };
        thread1.start();
        thread2.start();


    }
}
