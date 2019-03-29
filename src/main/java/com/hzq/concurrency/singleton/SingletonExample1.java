package com.hzq.concurrency.singleton;

import com.hzq.annoations.NotThreadSafe;

/**
 * 懒汉模式
 * 单例的实例在【第一次使用】的时候创建
 *
 * 这种写法 在单线程 时候 没有问题  但是在多线程情况下存在问题
 */
@NotThreadSafe
public class SingletonExample1 {
    /**
     * 私有的构造方法
     */
    private SingletonExample1(){

    }

    /**
     * 单例对象
     */
    private static SingletonExample1 instance=null;

    /**
     * 静态的工厂方法获取一个单例对象
     * @return
     */
    public static SingletonExample1 getInstance(){
        //在多线程的情况下  instance ==null  可能会被调用俩次
        if (instance==null){
            instance=new SingletonExample1();
        }
        return instance;
    }

}
