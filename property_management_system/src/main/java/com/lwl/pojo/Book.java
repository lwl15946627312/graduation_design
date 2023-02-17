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
@ApiModel("图书类")
public class Book {

    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("书名")
    private String bookName;
    @ApiModelProperty("作者")
    private String author;
    @ApiModelProperty("数量")
    private String number;

}
