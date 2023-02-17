package com.lwl.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@ApiModel("体育馆类")
public class Gymnasium {

    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("借用长的的名称")
    private String name;
    @ApiModelProperty("借用场地的地址")
    private String address;
    @ApiModelProperty("是否被借用")
    private String status;
    @ApiModelProperty("借用的人的系")
    private String department;
    @ApiModelProperty("借用的人")
    private String person;
    @ApiModelProperty("借用的人的角色")
    private String role;

}
