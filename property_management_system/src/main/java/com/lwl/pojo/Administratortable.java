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
@ApiModel("管理员类")
public class Administratortable {

    @ApiModelProperty("管理员id")
    private int id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("照片")
    private String photo;
    @ApiModelProperty("工号")
    private String jobNumber;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("创建时间")
    private String createDate;
    @ApiModelProperty("权限")
    private String perms;

}
