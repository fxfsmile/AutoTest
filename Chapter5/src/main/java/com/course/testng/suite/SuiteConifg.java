package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by fangxiaofei on 2019/9/17.
 */
public class SuiteConifg {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before Suite运行啦");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after Suite运行啦");
    }
}
