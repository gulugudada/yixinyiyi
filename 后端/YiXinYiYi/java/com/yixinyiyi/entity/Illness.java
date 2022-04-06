package com.yixinyiyi.entity;

import lombok.Data;

@Data
public class Illness {
    private int id;
    private String illnessname;
    private String introduction;
    private String feature;
    private String advice;
    private String image;
}
