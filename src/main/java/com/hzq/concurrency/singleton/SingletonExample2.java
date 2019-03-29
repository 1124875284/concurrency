package com.hzq.concurrency.singleton;

import com.hzq.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 单例的实例在【类装载】时候创建
 *
 * 如果私有构造有太多的处理的时候 会影响性能
 * 如果这个对象不会被使用，会造成资源的浪费
 *
 */
@ThreadSafe
public class SingletonExample2 {
    /**
     * 私有的构造方法
     */
    private SingletonExample2(){

    }

    /**
     * 单例对象
     */
    private static SingletonExample2 instance=new SingletonExample2();

    /**
     * 静态的工厂方法获取一个单例对象
     * @return
     */
    public static SingletonExample2 getInstance(){
        return instance;
    }

}
