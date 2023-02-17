package com.lwl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwl.mapper.StudentMapper;
import com.lwl.pojo.Student;
import com.lwl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentMapper studentMapper;

    /**
     *  登录
     * @param studentNumber 学号
     * @param password 密码
     * @return 学生信息
     */
    @Override
    public Student studentLogin(String studentNumber, String password) {
        return studentMapper.studentLogin(studentNumber,password);
    }

    /**
     * 查询所有学生 以分页的形式
     * @return 所有学生信息
     */
    @Override
    public PageInfo<Student> queryAllStudent(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Student> students = studentMapper.queryAllStudent();
        return new PageInfo<>(students);
    }

    /**
     * 管理员多条件查询学生
     * @return 学生信息
     */
    @Override
    public PageInfo<Student> selectSomeStudentByDepartmentOrStudentClassOrName(Integer pageNum, Integer pageSize,String department,String studentClass,String name) {
        PageHelper.startPage(pageNum,pageSize);
        List<Student> students = studentMapper.selectSomeStudentByDepartmentOrStudentClassOrName(department, studentClass, name);
        return new PageInfo<>(students);
    }

    /**
     * 注册学生
     * @return ok
     */
    @Override
    public int addStudent(String id,String name, String password, String sex, String dataOfBirth, String IdNumber, String phone, String email, String address, String studentNumber, String department, String studentClass, String birthplace, String admissionTime, String photo, String dorm, String evaluate, String classState, String bookState, String perms) {
        return studentMapper.addStudent(id,name,password,sex,dataOfBirth,IdNumber,phone,email,address,studentNumber,department,studentClass,
                birthplace,admissionTime,photo,dorm,evaluate,classState,bookState,perms);
    }

    /**
     * 管理员更改学生信息
     * @return ok
     */
    @Override
    public int adminUpdateStudent(String id,String name, String password, String dataOfBirth, String IdNumber, String phone, String email, String address, String studentNumber, String department, String studentClass, String birthplace, String admissionTime, String dorm, String evaluate, String classState, String bookState, String perms) {
        return studentMapper.adminUpdateStudent(id,name,password,dataOfBirth,IdNumber,phone,email,address,studentNumber,department,studentClass,
                birthplace,admissionTime,dorm,evaluate,classState,bookState,perms);
    }

    /**
     * 通过id查找学生
     * @param id 学生id
     * @return
     */
    @Override
    public Student checkOneStudentById(String id) {
        return studentMapper.checkOneStudentById(id);
    }

    /**
     * 通过id删除学生
     * @param id 学生id
     * @return ok
     */
    @Override
    public int adminDelStudent(String id) {
        return studentMapper.adminDelStudent(id);
    }

    /**
     * 查看本班级学生
     * @return 信息
     */
    @Override
    public PageInfo<Student> checkSelfDepartmentStudent(Integer pageNum, Integer pageSize, String department) {
        PageHelper.startPage(pageNum,pageSize);
        List<Student> students = studentMapper.checkSelfDepartmentStudent(department);
        return new PageInfo<>(students);
    }

    /**
     * 学生选课
     * @return
     */
    @Override
    public int studentChooseLogoCurriculumName(String classState, String id) {
        return studentMapper.studentChooseLogoCurriculumName(classState,id);
    }

    /**
     * 多条件查看学生
     * @return 信息
     */
    @Override
    public PageInfo<Student> teacherMoreChooseToCheckStudent(Integer pageNum, Integer pageSize,String department, String studentClass, String name) {
        PageHelper.startPage(pageNum,pageSize);
        List<Student> students = studentMapper.teacherMoreChooseToCheckStudent(department,studentClass, name);
        return new PageInfo<>(students);
    }

    /**
     * 查看个人信息
     * @return 信息
     */
    @Override
    public Student checkSelfMessage(String id) {
        return studentMapper.checkSelfMessage(id);
    }

    /**
     * 更改密码
     * @return ok
     */
    @Override
    public int studentUpdatePassword(String id, String password) {
        return studentMapper.studentUpdatePassword(id,password);
    }

    /**
     * 更改头像
     * @return ok
     */
    @Override
    public int studentUploadPhoto(String id, String photo) {
        return studentMapper.studentUploadPhoto(id,photo);
    }

    /**
     * 借书
     * @return ok
     */
    @Override
    public int studentBorrowBook(String id, String bookState) {
        return studentMapper.studentBorrowBook(id,bookState);
    }

    @Override
    public int updateEvaluateMessage(String evaluate, String id) {
        return studentMapper.updateEvaluateMessage(evaluate,id);
    }
}
