package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * Created by fangxiaofei on 2019/9/17.
 */

@Test(groups = "stu")
public class GroupsOnClass1 {

    public void stu1(){
        System.out.println("GroupsOnClass11111111111中的stu1运行");
    }

    public void stu2(){
        System.out.println("GroupsOnClass111111111111中的stu2运行");
    }
}
