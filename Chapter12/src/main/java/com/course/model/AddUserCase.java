package com.course.model;

import lombok.Data;

/**
 * Created by fangxiaofei on 2019/10/15.
 */
@Data
public class AddUserCase {
    private  String id;
    private String userName;
    private String password;
    private String sex;
    private String age;
    private String permission;
    private String isDelete;
    private String expected;
}
