package com.lwl.controller;

import com.github.pagehelper.PageInfo;
import com.lwl.pojo.Student;
import com.lwl.service.impl.StudentServiceImpl;
import com.lwl.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    /**
     * 查看本系的学生
     * @return 信息
     */
    @GetMapping("/teacherToCheckAllLearnSelfCourseStudentMessage")
    public String teacherToCheckAllLearnSelfCourseStudentMessage(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                                                 @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                                                 Model model){
        PageInfo<Student> studentPageInfo = studentService.checkSelfDepartmentStudent(pageNum, pageSize, Role.department);
        Role.pageLocation = "/teacherToCheckAllLearnSelfCourseStudentMessage";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",studentPageInfo);
        return "teacherToCheckAllLearnSelfCourseStudentMessage";
    }

    /**
     * 教师多条件查看本系学生
     * @return 信息
     */
    @GetMapping("/teacherCheckSomeCourses")
    public String teacherCheckSomeCourses(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                          @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                          Model model,String studentClass,String name){
        PageInfo<Student> studentPageInfo = studentService.teacherMoreChooseToCheckStudent(pageNum, pageSize,Role.department, studentClass, name);
        Role.pageLocation = "/teacherCheckSomeCourses";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",studentPageInfo);
        return "teacherToCheckAllLearnSelfCourseStudentMessage";
    }

    /**
     * 学生选修课程  ++++++ 可能改到查看自己信息
     * @return ok
     */
    @GetMapping("/studentToCheckAllCurriculumMessage/{curriculumName}")
    public String studentChooseCurriculum(@PathVariable("curriculumName") String curriculumName,Model model){
        studentService.studentChooseLogoCurriculumName(curriculumName,Role.id);
        Role.utilsLogin(model);
        return "redirect:/studentToCheckAllCurriculumMessage";
    }

}
