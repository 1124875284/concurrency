package com.hzq.concurrency.example.immutable;


import java.util.Map;
import com.google.common.collect.Maps;
import com.hzq.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 用final修饰的对象不可以指向另外一个对象，但是可以修改对象里的值
 * 线程不全全的
 */
@NotThreadSafe
@Slf4j
public class ImmutableExample1 {

    private final static Integer a=1;
    private final static String b="2";

    private final static Map<Integer,Integer> map=Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
        map.put(1,3);

        log.info("{}",map.get(1));
    }

}
