package com.lwl.service;

import com.lwl.pojo.StudentId;

public interface StudentIdService {

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
