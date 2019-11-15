package com.course.testng;

import org.omg.SendingContext.RunTime;
import org.testng.annotations.Test;
import org.w3c.dom.ranges.RangeException;

/**
 * Created by fangxiaofei on 2019/9/18.
 */
public class ExpectedException {

    //这是一个失败的异常
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常的测试");
    }




    //这是一个成功的异常
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是一个成功的异常测试");
        throw new RuntimeException();

    }


}
