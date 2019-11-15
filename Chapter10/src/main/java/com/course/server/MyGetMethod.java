package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omg.CORBA.Object;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by fangxiaofei on 2019/10/8.
 */

@RestController
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMethod {
    @RequestMapping(value = "/getcookie", method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到cookies",httpMethod = "Get")
    public String getCookies(HttpServletResponse response) {
        //HttpServletRequest装请求信息的类
        //HttpServletResponse装响应信息的类
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功";
    }

    /**
     * 要求客户端携带cookies访问
     * 这是一个需要携带cookies信息才能访问的get请求
     */

    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookies访问",httpMethod = "Get" )
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "你必须携带cookies信息来";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") &&
                    cookie.getValue().equals("true")) {
                return "恭喜你访问成功！";
            }
        }
        return "你必须携带cookies信息来";

    }


    /**
     *开发一个需要携带参数才能访问的get请求
     *第一种实现方式 URL： key=value&key=value
     * 我们来模拟获取商品列表
     */

    @RequestMapping(value = "/get/with/param", method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的get请求方法一",httpMethod = "Get")
    public Map<String,Integer> getList(@RequestParam Integer start,
                                       @RequestParam Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("学步鞋",500);
        myList.put("干脆面",2);
        myList.put("衬衫",300);

        return myList;
    }

    /**
     * 第二种需要携带参数访问的get请求
     * URL： ip:port、get/with/param/10/20
     */
    @RequestMapping(value = "/get/with/param/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的get请求方法二",httpMethod = "Get")
    public Map<String,Integer> myGetList(@PathVariable Integer start,
                                         @PathVariable Integer end){
        Map<String,Integer> myList1 = new HashMap<>();
        myList1.put("学步鞋",500);
        myList1.put("干脆面",2);
        myList1.put("衬衫",300);

        return myList1;

    }
}

