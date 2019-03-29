package com.hzq.concurrency.singleton;

import com.hzq.annoations.NotRecommed;
import com.hzq.annoations.ThreadSafe;

/**
 * 懒汉模式  实现线程安全  提高性能的写法
 * 单例的实例在【第一次使用】的时候创建
 *
 */
@ThreadSafe
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
     * 静态的工厂方法获取一个单例对象
     * @return
     */
    public static synchronized SingletonExample4 getInstance(){
        //双重检测装置
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
