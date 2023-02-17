package com.lwl.mapper;

import com.lwl.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {

    /**
     * 登录
     * @param jobNumber 工号
     * @param password 密码
     * @return 教师信息
     */
    Teacher teacherLogin(String jobNumber,String password);

    /**
     * 管理员查看所有教师
     * @return
     */
    List<Teacher> adminCheckAllTeacher();

    /**
     * 管理员多条件查询教师
     * @param department 部门
     * @param name 姓名
     * @return 教师信息
     */
    List<Teacher> adminCheckAllTeacherByDepartmentOrName(String department,String name);

    /**
     * 管理员添加教师信息
     * @return
     */
    int adminAddTeacherMessage(String id,String photo,String department,
                               String name,String sex,String phone,String email,
                               String jobNumber,String password,String perms);

    /**
     * 查询一条教师信息
     * @param id 教师id
     * @return 一条教师信息
     */
    Teacher adminCheckOneStudentById(String id);

    /**
     * 管理员修改教师信息
     * @return
     */
    int adminUpdateTeacherMessage(String id,String department,
                                  String name,String phone,String email,
                                  String password,String perms);

    /**
     * 管理员删除信息
     * @param id 教师id
     * @return ok
     */
    int adminDelTeacher(String id);

    /**
     * 查看个人信息
     * @return 信息
     */
    Teacher checkSelfMessage(String id);

    /**
     * 更改密码
     * @return ok
     */
    int teacherUpdatePassword(String id,String password);

    /**
     * 更改头像
     * @return ok
     */
    int teacherUploadPhoto(String id,String photo);

    /**
     * 查看教师id
     * @return 信息
     */
    Teacher queryTeacherId(String department,String name);
}
