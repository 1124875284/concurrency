package com.hzq.concurrency.singleton;

import com.hzq.annoations.NotRecommed;
import com.hzq.annoations.NotThreadSafe;
import com.hzq.annoations.ThreadSafe;

/**
 * 懒汉模式  ---》双重同步锁单例模式  也会存在线程安全问题 因为有：指令重排序的存在
 * 单例的实例在【第一次使用】的时候创建
 *
 */
@NotThreadSafe
public class SingletonExample4 {
    /**
     * 私有的构造方法
     */
    private SingletonExample4(){

    }

    /**
     * 单例对象
     */
    private static SingletonExample4 instance=null;

    /**
     * 当执行 instance=new SingletonExample4();时
     * 1、memory=allocate()  分配对象内存空间
     * 2、ctorInstance()  初始化对象
     * 3、instance=memory 设置instance指向刚分配的内存
     *
     * 在多线程情况下
     *  JVM和cpu优化，发生了指令重排序
     *  1、memory=allocate()  分配对象内存空间
     *  3、instance=memory 设置instance指向刚分配的内存
     *  2、ctorInstance()  初始化对象
     *
     */

    /**
     * 静态的工厂方法获取一个单例对象
     * @return
     */
    public static synchronized SingletonExample4 getInstance(){
        //双重检测机制
        if (instance==null){
            synchronized (SingletonExample4.class){
                //同步锁
                if (instance==null){
                    instance=new SingletonExample4();
                }
            }

        }
        return instance;
    }

}
