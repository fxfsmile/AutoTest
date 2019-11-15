package com.course.testng.multiThread;

import org.testng.annotations.Test;

/**
 * Created by fangxiaofei on 2019/9/19.
 */
public class MultiThreadOnAnnotation {

    @Test(invocationCount = 8,threadPoolSize = 5)
    public void test1(){
        System.out.printf("Thread1 Id is: %s%n",Thread.currentThread().getId());
    }

}
