package com.hzq.concurrency.example.publish;

import com.hzq.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 对象的发布
 */
@Slf4j
@NotThreadSafe
public class UnSafePublish {

    private String[] states={"a","b","c"};
    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnSafePublish unSafePublish=new UnSafePublish();
        log.info("{}",Arrays.toString(unSafePublish.getStates()));
        //尝试对他私有数据的数组进行修改
        unSafePublish.getStates()[0]="d";
        log.info("{}",Arrays.toString(unSafePublish.getStates()));

    }

}
