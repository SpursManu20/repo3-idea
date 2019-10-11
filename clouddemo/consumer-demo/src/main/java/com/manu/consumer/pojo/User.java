package com.manu.consumer.pojo;

import lombok.Data;

@Data   //使用@Date注解可以自动导入setter和getter方法
public class User{

    private Integer id;
    private String name;
    private String password;
    private String gender;
}
