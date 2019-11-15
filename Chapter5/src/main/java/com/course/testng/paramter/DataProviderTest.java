package com.course.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by fangxiaofei on 2019/9/18.
 */
public class DataProviderTest {

    @Test(dataProvider = "data")
     public void testDataProvider(String name, int age){
        System.out.println("name = "+ name + ", age = "+ age);
    }

    @DataProvider(name="data")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"zhangsan",18},
                {"lisi",20},
                {"lilei",25}
        };
        return o;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test1方法 name=" + name +",age="+age);
    }

    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test2方法 name=" + name +",age="+age);
    }



}
