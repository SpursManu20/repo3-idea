package com.manu.user.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@Table(name = "user")   //将此类与数据库中的表建立映射关系
public class User {

    @Id     //标示主键
    @KeySql(useGeneratedKeys = true)    //标示主键自增
    private Integer id;

    private String name;

    private String password;

    private String gender;

    //备注
    @Transient      //不需要持久化到数据库的字段，数据库中可以没有的字段
    private String note;
}
