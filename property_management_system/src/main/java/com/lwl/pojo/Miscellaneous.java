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
@ApiModel("通知类")
public class Miscellaneous {

    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("通知名字")
    private String name;
    @ApiModelProperty("那个系的人")
    private String department;
    @ApiModelProperty("解决与否")
    private String logo;
    @ApiModelProperty("身份")
    private String identity;
    @ApiModelProperty("那个系的人")
    private String createPerson;
    @ApiModelProperty("被谁看见")
    private String look;

}
