package com.lwl.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("教师类")
public class Teacher {

    @ApiModelProperty("教师id")
    private String id;
    @ApiModelProperty("照片")
    private String photo;
    @ApiModelProperty("部门")
    private String department;
    @ApiModelProperty("教师姓名")
    private String name;
    @ApiModelProperty("教师性别")
    private String sex;
    @ApiModelProperty("教师电话")
    private String phone;
    @ApiModelProperty("邮件")
    private String email;
    @ApiModelProperty("工号")
    private String jobNumber;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("权限")
    private String perms;

}
