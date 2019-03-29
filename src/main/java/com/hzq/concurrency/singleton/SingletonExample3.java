package com.hzq.concurrency.singleton;

import com.hzq.annoations.NotRecommed;
import com.hzq.annoations.ThreadSafe;

/**
 * 懒汉模式  实现线程安全  在获取实例的静态工厂方法中加入 synchronized  但是不推介，会影响性能
 * 单例的实例在【第一次使用】的时候创建
 *
 */
@ThreadSafe
@NotRecommed
public class SingletonExample3 {
    /**
     * 私有的构造方法
     */
    private SingletonExample3(){

    }

    /**
     * 单例对象
     */
    private static SingletonExample3 instance=null;

    /**
     * 静态的工厂方法获取一个单例对象
     * @return
     */
    public static synchronized SingletonExample3 getInstance(){
        if (instance==null){
            instance=new SingletonExample3();
        }
        return instance;
    }

}
