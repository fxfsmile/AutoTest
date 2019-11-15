package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Created by fangxiaofei on 2019/9/23.
 */
public class TestMethodDemo {

    @Test
    public void test1(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void test3(){
        Assert.assertEquals("aaa","aaa");
    }

    @Test
    public void logDemo(){
        Reporter.log("这是我们自己写的日志");
        throw new RuntimeException("这是我们自己运行时的异常");
    }
}
