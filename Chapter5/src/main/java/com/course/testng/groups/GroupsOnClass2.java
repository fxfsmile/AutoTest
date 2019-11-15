package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * Created by fangxiaofei on 2019/9/17.
 */

@Test(groups = "stu")
public class GroupsOnClass2 {
    public void stu1(){
        System.out.println("GroupsOnClass22222222222中的stu1运行");
    }

    public void stu2(){
        System.out.println("GroupsOnClass222222222222中的stu2运行");
    }
}
