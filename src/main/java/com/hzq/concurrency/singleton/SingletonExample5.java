package com.hzq.concurrency.singleton;

import com.hzq.annoations.ThreadSafe;

/**
 *
 * 俗称 double check
 * 懒汉模式  ---》双重同步锁单例模式  也会存在线程安全问题  必须限制指令重排序，用volatile
 * 单例的实例在【第一次使用】的时候创建
 *
 */
@ThreadSafe
public class SingletonExample5 {
    /**
     * 私有的构造方法
     */
    private SingletonExample5(){

    }

    /**
     * 单例对象  volatile +双重检测机制---》禁止指令重排序
     */
    private volatile static SingletonExample5 instance=null;

    /**
     * 当执行 instance=new SingletonExample4();时
     * 1、memory=allocate()  分配对象内存空间
     * 2、ctorInstance()  初始化对象
     * 3、instance=memory 设置instance指向刚分配的内存
     *

     *
     */

    /**
     * 静态的工厂方法获取一个单例对象
     * @return
     */
    public static synchronized SingletonExample5 getInstance(){
        //双重检测机制
        if (instance==null){
            synchronized (SingletonExample5.class){
                //同步锁
                if (instance==null){
                    instance=new SingletonExample5();
                }
            }

        }
        return instance;
    }

}
