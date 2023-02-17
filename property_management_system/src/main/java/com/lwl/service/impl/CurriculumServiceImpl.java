package com.lwl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwl.mapper.CurriculumMapper;
import com.lwl.pojo.Curriculum;
import com.lwl.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumServiceImpl implements CurriculumService {

    @Autowired
    CurriculumMapper curriculumMapper;

    /**
     * 管理员分页查询所有课程信息
     * @return 信息
     */
    @Override
    public PageInfo<Curriculum> adminQueryAllCurriculumMessage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Curriculum> curricula = curriculumMapper.adminQueryAllCurriculumMessage();
        return new PageInfo<>(curricula);
    }

    /**
     * 管理员添加信息
     * @return ok
     */
    @Override
    public int adminAddCurriculumMessage(String id, String curriculumName, String department, String teacher, String logo) {
        return curriculumMapper.adminAddCurriculumMessage(id, curriculumName, department, teacher, logo);
    }

    /**
     * 多条件查询磕碜信息
     * @return 信息
     */
    @Override
    public PageInfo<Curriculum> moreChooseToCheckCurriculumMessage(Integer pageNum, Integer pageSize, String department,String curriculumName, String logo) {
        PageHelper.startPage(pageNum,pageSize);
        List<Curriculum> curricula = curriculumMapper.moreChooseToCheckCurriculumMessage(department,curriculumName, logo);
        return new PageInfo<>(curricula);
    }

    /**
     * 删除课程信息
     * @return ok
     */
    @Override
    public int adminDelCurriculumMessage(String id) {
        return curriculumMapper.adminDelCurriculumMessage(id);
    }

    /**
     * 教师查看自己的课程信息
     * @return 信息
     */
    @Override
    public PageInfo<Curriculum> teacherCheckSelfCurriculumMessage(Integer pageNum, Integer pageSize, String department, String teacher) {
        PageHelper.startPage(pageNum,pageSize);
        List<Curriculum> curricula = curriculumMapper.teacherCheckSelfCurriculumMessage(department, teacher);
        return new PageInfo<>(curricula);
    }

    /**
     * 查看所有选修课
     * @return 信息
     */
    @Override
    public PageInfo<Curriculum> checkAllChooseCurriculumMessage(Integer pageNum, Integer pageSize, String logo) {
        PageHelper.startPage(pageNum,pageSize);
        List<Curriculum> curricula = curriculumMapper.checkAllChooseCurriculumMessage(logo);
        return new PageInfo<>(curricula);
    }

    /**
     * 查看学生课程
     * @return 信息
     */
    @Override
    public PageInfo<Curriculum> checkOneStudentCurriculumMessage(Integer pageNum, Integer pageSize, String department, String logo) {
        PageHelper.startPage(pageNum,pageSize);
        List<Curriculum> curricula = curriculumMapper.checkOneStudentCurriculumMessage(department, logo);
        return new PageInfo<>(curricula);
    }

    /**
     * 查看教师部门和姓名
     * @return 信息
     */
    @Override
    public Curriculum checkTeacherMessage(String bookName) {
        return curriculumMapper.checkTeacherMessage(bookName);
    }
}
