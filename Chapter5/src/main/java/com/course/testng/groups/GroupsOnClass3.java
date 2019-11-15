package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * Created by fangxiaofei on 2019/9/17.
 */
@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void teacher1(){
        System.out.println("GroupsOnClass3333333中的teacher1运行");
    }

    public void teacher2(){
        System.out.println("GroupsOnClass3333333中的teacher2运行");
    }
}
