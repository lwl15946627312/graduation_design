package com.lwl.service.impl;

import com.lwl.mapper.StudentIdMapper;
import com.lwl.pojo.StudentId;
import com.lwl.service.StudentIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentIdServiceImpl implements StudentIdService {

    @Autowired
    StudentIdMapper studentIdMapper;

    /**
     * 预定体育场
     * @return ok
     */
    @Override
    public int addMessage(String studentId, String gymnasiumId) {
        return studentIdMapper.addMessage(studentId,gymnasiumId);
    }

    /**
     * 查询一条信息
     * @return 信息
     */
    @Override
    public StudentId queryOneMessage(String studentId) {
        return studentIdMapper.queryOneMessage(studentId);
    }

    /**
     * 删除
     * @return ok
     */
    @Override
    public int delOne(String id) {
        return studentIdMapper.delOne(id);
    }
}
