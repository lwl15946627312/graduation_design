package com.lwl.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@ApiModel("订餐表")
public class Order {

    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("订餐人")
    private String name;
    @ApiModelProperty("食物名称")
    private String foodName;
    @ApiModelProperty("价格")
    private String price;
    @ApiModelProperty("角色")
    private String role;
    @ApiModelProperty("归属系")
    private String department;
    @ApiModelProperty("照片")
    private String photo;
}
