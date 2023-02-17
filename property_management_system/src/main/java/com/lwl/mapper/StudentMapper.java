package com.lwl.mapper;

import com.lwl.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {

    /**
     * 登录
     * @param studentNumber 学号
     * @param password 密码
     * @return 学生信息
     */
    Student studentLogin(String studentNumber,String password);

    /**
     * 查询所有学生
     * @return
     */
    List<Student> queryAllStudent();

    /**
     *  管理员添加学生
     * @return ok
     */
    int addStudent(String id,String name,String password,String sex,
                   String dataOfBirth,String IdNumber,String phone,
                   String email,String address,String studentNumber,
                   String department,String studentClass,String birthplace,
                   String admissionTime,String photo,String dorm,String evaluate,
                   String classState,String bookState,String perms);

    /**
     * 管理员更改学生信息
     * @return ok
     */
    int adminUpdateStudent(String id,String name,String password,
                           String dataOfBirth,String IdNumber,String phone,
                           String email,String address,String studentNumber,
                           String department,String studentClass,String birthplace,
                           String admissionTime,String dorm,String evaluate,
                           String classState,String bookState,String perms);

    /**
     * 根据id查找学生
     * @param id 学生id
     * @return 一条学生信息
     */
    Student checkOneStudentById(String id);

    /**
     * 管理员删除学生
     * @return ok
     */
    int adminDelStudent(String id);

    /**
     * 按条件查询学生
     * @param department 系
     * @param studentClass 班级
     * @param name 姓名
     * @return 学生信息
     */
    List<Student> selectSomeStudentByDepartmentOrStudentClassOrName(String department,String studentClass,String name);

    /**
     * 查看本班级学生
     * @return ok
     */
    List<Student> checkSelfDepartmentStudent(String department);

    /**
     * 学生选课
     * @return ok
     */
    int studentChooseLogoCurriculumName(String classState,String id);

    /**
     * 教师多条件查询学生
     * @return 信息
     */
    List<Student> teacherMoreChooseToCheckStudent(String department,String studentClass,String name);

    /**
     * 查看个人信息
     * @return 信息
     */
    Student checkSelfMessage(String id);

    /**
     * 更改密码
     * @return 信息
     */
    int studentUpdatePassword(String id,String password);

    /**
     * 更改头像
     * @return ok
     */
    int studentUploadPhoto(String id,String photo);

    /**
     * 借书
     * @return ok
     */
    int studentBorrowBook(String id,String bookState);

    /**
     * 预定体育场
     * @return ok
     */
    int updateEvaluateMessage(String evaluate,String id);
}
