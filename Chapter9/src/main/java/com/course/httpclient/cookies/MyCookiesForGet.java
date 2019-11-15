package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by fangxiaofei on 2019/9/26.
 */
public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    //要来存储cookies信息的变量
    private CookieStore store;

    @BeforeTest
    public void  beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);//读取配置文件
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
       String result;
        //从配置文件中拼接url
        String uri = bundle.getString("test.getCookies.uri");
        String testUrl = this.url + uri;

        //get接口逻辑验证
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);//调用get方法，把返回结果存于response
        result = EntityUtils.toString(response.getEntity(),"gbk"); //把返回结果取出，存于result
        System.out.println(result);

        //怎么获取cookie信息
        this.store = client.getCookieStore(); //获取cookie
        List<Cookie> cookieList = store.getCookies(); //cookie值读取，存于list

        //遍历，取出cookie的键值对
        for(Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println(name+" = "+value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url + uri;

        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        //设置cookies信息
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);

        //获取响应状态码
        int status = response.getStatusLine().getStatusCode();
        System.out.println("状态码statusCode = " + status);

        //返回正确时取返回数据
        if (status == 200){
           String result = EntityUtils.toString(response.getEntity(),"gbk");
            System.out.println("返回的结果是:"+result);
        }


    }

}
