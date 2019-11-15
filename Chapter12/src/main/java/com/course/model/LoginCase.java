package com.course.model;

import lombok.Data;

/**
 * Created by fangxiaofei on 2019/10/15.
 */

@Data
public class LoginCase {
    private int id;
    private String userName;
    private String password;
    private String expected;
}
