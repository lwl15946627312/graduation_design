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
@ApiModel("课程类")
public class Curriculum {

    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("课程名称")
    private String curriculumName;
    @ApiModelProperty("系部")
    private String department;
    @ApiModelProperty("教授教师")
    private String teacher;
    @ApiModelProperty("选修/必修")
    private String logo;

}
