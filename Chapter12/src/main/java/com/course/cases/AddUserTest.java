package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.AddUserCase;
import com.course.model.User;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;

import java.io.IOException;

/**
 * Created by fangxiaofei on 2019/10/18.
 */
public class AddUserTest {

    @Test(dependsOnGroups = "loginTrue",description = "添加用户接口测试")
    public void addUser() throws IOException, InterruptedException {
        SqlSession session = DatabaseUtil.getSqlSession();
        AddUserCase addUserCase = session.selectOne("addUserCase",20);
        System.out.println(addUserCase.toString());
        System.out.println(TestConfig.addUserUrl);




        //发送请求，获取结果
        String result = getResult(addUserCase);

        Thread.sleep(3000);
        //验证返回结果
        User user = session.selectOne("addUser",addUserCase);

//        System.out.println(user.toString());

        Assert.assertEquals(addUserCase.getExpected(),result);

    }

    private String getResult(AddUserCase addUserCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.addUserUrl);
        JSONObject param = new JSONObject();
        param.put("userName",addUserCase.getUserName());
        param.put("password",addUserCase.getPassword());
        param.put("sex",addUserCase.getSex());
        param.put("age",addUserCase.getAge());
        param.put("permission",addUserCase.getPermission());
        param.put("isDelete",addUserCase.getIsDelete());

        //设置头信息
        post.setHeader("Content-Type","application/json");

        //传入参数
        StringEntity entity =  new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        //设置cookies
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);

        //执行方法，返回结果
        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");

        System.out.println(result.toString());
        return result;


    }
}
