package com.course.testng;

import org.testng.annotations.Test;

/**
 * Created by fangxiaofei on 2019/9/17.
 */
public class IgnoreTest {

    @Test
    public void ignore1(){
        System.out.println("ignore1 执行");
    }

    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2 执行");
    }
}
