package com.hzq.concurrency.example.immutable;


import com.google.common.collect.Maps;
import com.hzq.annoations.NotThreadSafe;
import com.hzq.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * Collections.unmodifiableMap()
 */
@ThreadSafe
@Slf4j
public class ImmutableExample2 {

    private static Map<Integer,Integer> map=Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
        map=Collections.unmodifiableMap(map);
        //Collections.unmodifiableMap(map) 通过它处理过的对象，里面的内容是不可以被修改的
    }

    public static void main(String[] args) {
        map.put(1,3);

        log.info("{}",map.get(1));
    }
    
}
