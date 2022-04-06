package com.yixinyiyi.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class User {
    private int id;
    private String username;
    private Date birthday;
    private String sex;
    private String constellation;
    private String school;
    private String grade;
    private String college;
    private String administrativeclass;
    private String location;
    private String geqian;
    private String touxiang;
}
