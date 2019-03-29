package com.hzq.concurrency.singleton;

import com.hzq.annoations.NotRecommed;
import com.hzq.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 单例的实例在【类装载】时候创建
 *
 * 用静态代码块去实例对象
 */
@ThreadSafe
public class SingletonExample6 {
    /**
     * 私有的构造方法
     */
    private SingletonExample6(){

    }
    /**
     * 单例对象
     */
    private static SingletonExample6 instance=null;
    static {
        instance=new SingletonExample6();
    }
    /**
     * 静态的工厂方法获取一个单例对象
     * @return
     */
    public static SingletonExample6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }

}
