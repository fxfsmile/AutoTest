package com.course.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by fangxiaofei on 2019/10/16.
 */
public class TestConfig {
    public static String loginUrl;
    public static String updateUserInfoUrl;
    public static String getUserListUrl;
    public  static String getUserInfoUrl;
    public static String addUserUrl;

    public  static DefaultHttpClient defaultHttpClient ;
    public  static CookieStore cookieStore;
}
