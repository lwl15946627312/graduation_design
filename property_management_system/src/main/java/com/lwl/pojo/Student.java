package com.lwl.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@ApiModel("学生类")
public class Student {
    @ApiModelProperty("学生编号")
    private String id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("出生日期")
    private String dataOfBirth;
    @ApiModelProperty("身份证号")
    private String IdNumber;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("邮件")
    private String email;
    @ApiModelProperty("地址")
    private String address;
    @ApiModelProperty("学号")
    private String studentNumber;
    @ApiModelProperty("系")
    private String department;
    @ApiModelProperty("班级")
    private String studentClass;
    @ApiModelProperty("生源地")
    private String birthplace;
    @ApiModelProperty("入校时间")
    private String admissionTime;
    @ApiModelProperty("照片")
    private String photo;
    @ApiModelProperty("寝室")
    private String dorm;
    @ApiModelProperty("评价")
    private String evaluate;
    @ApiModelProperty("选修课")
    private String classState;
    @ApiModelProperty("借书")
    private String bookState;
    @ApiModelProperty("权限")
    private String perms;

}
