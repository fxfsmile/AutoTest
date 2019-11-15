package com.course.model;

import lombok.Data;

/**
 * Created by fangxiaofei on 2019/10/22.
 */
@Data
public class User {
    private int id;
    private String userName;
    private String password;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;
}

