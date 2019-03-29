package com.hzq.concurrency.example.publish;

import com.hzq.annoations.NotRecommed;
import com.hzq.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 对象溢出
 *
 * 就是在对象未完成构造之前不可以将其发布
 */
@Slf4j
@NotThreadSafe
@NotRecommed
public class Escape {

    private int thisCannBeEscape=0;

    public Escape(){
        new InnerClass();
    }

    private class InnerClass{

        public InnerClass(){
            log.info("{}",Escape.this.thisCannBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }

}
