package com.course.testng.multiThread;

import org.testng.annotations.Test;

/**
 * Created by fangxiaofei on 2019/9/20.
 */
public class MulitThreadOnXml {
    @Test
    public void test1(){
        System.out.printf("Thread1 Id is: %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.printf("Thread2 Id is:%s%n",Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.printf("Thread3 Id is:%s%n",Thread.currentThread().getId());
    }
}
