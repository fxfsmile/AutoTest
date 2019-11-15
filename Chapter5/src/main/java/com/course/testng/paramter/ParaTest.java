package com.course.testng.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by fangxiaofei on 2019/9/18.
 */
public class ParaTest {


    @Parameters ({"name","age"})
    @Test
    public void paraTest1(String name, int age){
        System.out.println("name = " + name + ",age = " + age);

    }
}
