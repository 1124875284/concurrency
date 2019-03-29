package com.hzq.concurrency.example.immutable;


import com.google.common.collect.*;
import com.hzq.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 *
 */
@ThreadSafe
@Slf4j
public class ImmutableExample3 {

    private final static ImmutableList list=ImmutableList.of(1,2,3);

    private final static ImmutableSet set=ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer,Integer> map=ImmutableMap.of(1,2,3,4);
    public static void main(String[] args) {
        //是不可以被修改的
//        map.put(1,4);
//        list.add(4);
        System.out.println(map.get(1));
    }

}
