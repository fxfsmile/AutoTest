package com.course.model;

import lombok.Data;

/**
 * Created by fangxiaofei on 2019/10/15.
 */
@Data
public class GetUserInfoCase {
    private int id;
    private int userId;
    private String expected;
}
