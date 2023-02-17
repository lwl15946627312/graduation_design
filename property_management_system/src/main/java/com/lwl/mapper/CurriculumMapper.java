package com.lwl.mapper;

import com.lwl.pojo.Curriculum;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CurriculumMapper {

    /**
     * 管理员查看所有课程信息
     * @return 信息
     */
    List<Curriculum> adminQueryAllCurriculumMessage();

    /**
     * 管理员添加信息
     * @return ok
     */
    int adminAddCurriculumMessage(String id,String curriculumName,String department,String teacher,String logo);

    /**
     * 多条件查询课程信息
     * @return 信息
     */
    List<Curriculum> moreChooseToCheckCurriculumMessage(String department,String curriculumName,String logo);

    /**
     * 管理员删除课程信息
     * @return 信息
     */
    int adminDelCurriculumMessage(String id);

    /**
     * 教师查询自己的课程
     * @return 信息
     */
    List<Curriculum> teacherCheckSelfCurriculumMessage(String department,String teacher);

    /**
     * 查看所有的选修课
     * @return 信息
     */
    List<Curriculum> checkAllChooseCurriculumMessage(String logo);

    /**
     * 查看学生课程
     * @return 信息
     */
    List<Curriculum> checkOneStudentCurriculumMessage(String department,String logo);

    /**
     * 查看教师姓名部门
     * @return 信息
     */
    Curriculum checkTeacherMessage(String bookName);

}
