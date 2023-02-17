package com.lwl.service;

import com.github.pagehelper.PageInfo;
import com.lwl.pojo.Curriculum;

public interface CurriculumService {

    /**
     * 管理员查看所有课程信息 分页
     * @return 信息
     */
    PageInfo<Curriculum> adminQueryAllCurriculumMessage(Integer pageNum,Integer pageSize);

    /**
     * 管理员添加信息
     * @return ok
     */
    int adminAddCurriculumMessage(String id,String curriculumName,String department,String teacher,String logo);

    /**
     * 多条件查询课程信息
     * @return 信息
     */
    PageInfo<Curriculum> moreChooseToCheckCurriculumMessage(Integer pageNum,Integer pageSize,String department,String curriculumName,String logo);

    /**
     * 管理员删除课程信息
     * @return 信息
     */
    int adminDelCurriculumMessage(String id);

    /**
     * 教师查询自己的课程信息
     * @return 信息
     */
    PageInfo<Curriculum> teacherCheckSelfCurriculumMessage(Integer pageNum,Integer pageSize,String department,String teacher);

    /**
     * 查看所有的选修课
     * @return 信息
     */
    PageInfo<Curriculum> checkAllChooseCurriculumMessage(Integer pageNum,Integer pageSize,String logo);

    /**
     * 查看学生课程
     * @return 信息
     */
    PageInfo<Curriculum> checkOneStudentCurriculumMessage(Integer pageNum,Integer pageSize,String department,String logo);

    /**
     * 查看教师姓名部门
     * @return 信息
     */
    Curriculum checkTeacherMessage(String bookName);

}
