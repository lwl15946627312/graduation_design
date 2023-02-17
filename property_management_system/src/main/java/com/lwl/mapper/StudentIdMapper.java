package com.lwl.mapper;

import com.lwl.pojo.StudentId;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentIdMapper {

    /**
     * 添加预定场馆信息
     * @return ok
     */
    int addMessage(String studentId,String gymnasiumId);

    /**
     * 查询一条信息
     * @return 信息
     */
    StudentId queryOneMessage(String studentId);

    /**
     * 删除
     * @return ok
     */
    int delOne(String id);
}
