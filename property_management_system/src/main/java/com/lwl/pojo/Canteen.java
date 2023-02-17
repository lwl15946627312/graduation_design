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
@ApiModel("餐厅类")
public class Canteen {

    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("菜名")
    private String name;
    @ApiModelProperty("照片")
    private String photo;
    @ApiModelProperty("价格")
    private String price;
    @ApiModelProperty("今日菜单")
    private String today;
}
