package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by fangxiaofei on 2019/9/26.
 */
public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;

    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle =ResourceBundle.getBundle("application", Locale.CHINA);//读取配置文件
        url = bundle.getString("test.url");//从配置文件中读取url
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        //拼接get接口的url
        String uri = bundle.getString("test.getCookies.uri");
        String testUrl =this.url + uri;

        //接口逻辑验证
        //client对象(修改HttpClient，应该此对象没有getCookieStore方法的，无法获取cookie信息)
        DefaultHttpClient client = new DefaultHttpClient();
        //请求get
        HttpGet get = new HttpGet(testUrl);
        //d调用get方法
        HttpResponse response = client.execute(get);
        //取出返回数据
        result = EntityUtils.toString(response.getEntity(),"gbk");
        System.out.println("返回结果是："+result);


        //获取cookie信息
        //DefaultHttpClient才有getCookieStore()方法
         store = client.getCookieStore();
        List<Cookie> cookielist = store.getCookies(); //提取返回的cookie

        //cookie中提取有用信息
        for(Cookie cookie : cookielist){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie的name = "+name + ";   cookie的 value = " + value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostCookie() throws IOException {
        //拼接url
            String uri = bundle.getString("test.post.with.cookies");
            String testUrl = this.url + uri;

        //声明一个Client对象，用于进行方法的执行
        DefaultHttpClient client = new DefaultHttpClient();

        //声明一个post方法
        HttpPost post = new HttpPost(testUrl);

        //设置cookie
        client.setCookieStore(this.store);

        //设置请求头信息，设置header
        post.setHeader("Content-Type","application/json");

        //设置传入数据
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");

        //把参数数据添加到post方法中
        StringEntity entity = new StringEntity(param.toString(),"gbk");
        post.setEntity(entity);

        //调用post
        HttpResponse response= client.execute(post);

        //获取响应结果
        String reslut;
        reslut = EntityUtils.toString(response.getEntity(),"gbk");
        System.out.println(reslut);

        //处理结果，就是判断返回结果是否符合预期
        //将返回的响应结果字符串转换为json
        JSONObject reslutJson = new JSONObject(reslut);
        //判断返回的json结果是否正确
        String success = (String) reslutJson.get("huhansan");
        String status = (String) reslutJson.get("status");
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);
    }
}
