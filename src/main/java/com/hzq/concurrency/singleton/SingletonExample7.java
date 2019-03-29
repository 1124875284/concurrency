package com.hzq.concurrency.singleton;


import com.hzq.annoations.Recommed;
import com.hzq.annoations.ThreadSafe;

/**
 * 枚举模式： 最安全的
 *
 * 利用枚举 来做实例化   相比于懒汉模式 安全性更加可以保证，
 *      相比于饿汉 模式 实际调用的时候才会初始化不会造成资源的浪费
 */
@ThreadSafe
@Recommed
public class SingletonExample7 {

    private SingletonExample7(){
    }

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{

        INSTANCE;

        private SingletonExample7 singleton;

        /**
         * JVM保证这个方法只被调用一次
         */
        Singleton(){
            singleton=new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return singleton;
        }
    }
}
