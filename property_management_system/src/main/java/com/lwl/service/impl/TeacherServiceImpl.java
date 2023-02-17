package com.lwl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwl.mapper.TeacherMapper;
import com.lwl.pojo.Teacher;
import com.lwl.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    /**
     *  登录
     * @param jobNumber 工号
     * @param password 密码
     * @return 教师信息
     */
    @Override
    public Teacher teacherLogin(String jobNumber, String password) {
        return teacherMapper.teacherLogin(jobNumber,password);
    }

    /**
     * 查询所有教师信息以分页的方式
     * @param pageNum 一页
     * @param pageSize 几条数据
     * @return 全部教师信息
     */
    @Override
    public PageInfo<Teacher> adminCheckAllTeacher(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Teacher> teachers = teacherMapper.adminCheckAllTeacher();
        return new PageInfo<>(teachers);
    }

    /**
     * 多条件查询教师
     * @return 教师信息
     */
    @Override
    public PageInfo<Teacher> adminCheckAllTeacherByDepartmentOrName(Integer pageNum, Integer pageSize,String department,
                                                                    String name) {
        PageHelper.startPage(pageNum,pageSize);
        List<Teacher> teachers = teacherMapper.adminCheckAllTeacherByDepartmentOrName(department, name);
        return new PageInfo<>(teachers);
    }

    /**
     * 管理员添加教师信息
     * @return ok
     */
    @Override
    public int adminAddTeacherMessage(String id, String photo, String department, String name, String sex, String phone, String email, String jobNumber, String password, String perms) {
        return teacherMapper.adminAddTeacherMessage(id,photo,department,name,sex,phone,email,jobNumber,password,perms);
    }

    /**
     * 查看学生
     * @return 信息
     */
    @Override
    public Teacher adminCheckOneStudentById(String id) {
        return teacherMapper.adminCheckOneStudentById(id);
    }

    /**
     * 修改
     * @return ok
     */
    @Override
    public int adminUpdateTeacherMessage(String id, String department, String name, String phone, String email, String password, String perms) {
        return teacherMapper.adminUpdateTeacherMessage(id,department,name,phone,email,password,perms);
    }

    /**
     * 删除
     * @return ok
     */
    @Override
    public int adminDelTeacher(String id) {
        return teacherMapper.adminDelTeacher(id);
    }

    /**
     * 查看个人信息
     * @return 信息
     */
    @Override
    public Teacher checkSelfMessage(String id) {
        return teacherMapper.checkSelfMessage(id);
    }

    /**
     * 更改密码
     * @return ok
     */
    @Override
    public int teacherUpdatePassword(String id, String password) {
        return teacherMapper.teacherUpdatePassword(id,password);
    }

    /**
     * 更改头像
     * @return ok
     */
    @Override
    public int teacherUploadPhoto(String id, String photo) {
        return teacherMapper.teacherUploadPhoto(id,photo);
    }

    /**
     * 查看id
     * @return 信息
     */
    @Override
    public Teacher queryTeacherId(String department, String name) {
        return teacherMapper.queryTeacherId(department,name);
    }
}
