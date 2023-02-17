package com.lwl.controller;

import com.github.pagehelper.PageInfo;
import com.lwl.pojo.Curriculum;
import com.lwl.service.impl.CurriculumServiceImpl;
import com.lwl.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurriculumController {

    @Autowired
    CurriculumServiceImpl curriculumService;

    /**
     * 请求分发
     * @return 跳转
     */
    @GetMapping("/checkAllCurriculum")
    public String checkAllCurriculum(Model model){
        if(Role.role.equals("管理员")){
            return "redirect:/adminToCheckAllCurriculumMessage";
        }else if(Role.role.equals("教师")){
            return "redirect:/teacherToCheckAllCurriculumMessage";
        }else if(Role.role.equals("学生")){
            return "redirect:/studentToCheckAllCurriculumMessage";
        }else {
            Role.utilsLogin(model);
            return "index";
        }
    }

    /**
     * 管理员查看所有的课程信息
     * @return 信息
     */
    @GetMapping("/adminToCheckAllCurriculumMessage")
    public String adminToCheckAllCurriculumMessage(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                                   @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                                   Model model){
        PageInfo<Curriculum> curriculumPageInfo = curriculumService.adminQueryAllCurriculumMessage(pageNum, pageSize);
        Role.pageLocation = "/adminToCheckAllCurriculumMessage";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",curriculumPageInfo);
        return "adminCheckAllCurriculum";
    }

    /**
     * 管理员去添加课程
     * @return 跳转
     */
    @GetMapping("/toAdminAddCurriculumMessage")
    public String toAdminAddCurriculumMessage(Model model){
        Role.utilsLogin(model);
        return "AdminAddCurriculum";
    }

    /**
     * 管理员添加信息
     * @return 信息
     */
    @PostMapping("/adminAddCurriculumMessage")
    public String adminAddCurriculumMessage (Model model,String curriculumName,String department,String teacher,String logo){
        curriculumService.adminAddCurriculumMessage(Role.createUUID(),curriculumName,department,teacher,logo);
        Role.utilsLogin(model);
        return "redirect:/adminToCheckAllCurriculumMessage";
    }

    /**
     * 多条件查询课程信息
     * @return 信息
     */
    @GetMapping("/adminCheckSomeCurriculum")
    public String adminCheckSomeCurriculum(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                           Model model,String department,String curriculumName,String logo){
        PageInfo<Curriculum> curriculumPageInfo = curriculumService.moreChooseToCheckCurriculumMessage(pageNum, pageSize, department, curriculumName, logo);
        System.out.println(department+curriculumName+logo);
        Role.pageLocation = "/adminCheckSomeCurriculum";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",curriculumPageInfo);
        return "adminCheckAllCurriculum";
    }

    @GetMapping("/delCurriculum/{id}")
    public String delCurriculum(@PathVariable("id") String id,Model model){
        curriculumService.adminDelCurriculumMessage(id);
        Role.utilsLogin(model);
        return "redirect:/adminToCheckAllCurriculumMessage";
    }

    /**
     *  教师查看自己的课程
     * @return 信息
     */
    @GetMapping("/teacherToCheckAllCurriculumMessage")
    public String teacherToCheckAllCurriculumMessage(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                                     @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                                     Model model){
        PageInfo<Curriculum> curriculumPageInfo = curriculumService.teacherCheckSelfCurriculumMessage(pageNum, pageSize, Role.department, Role.name);
        Role.pageLocation = "/teacherToCheckAllCurriculumMessage";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",curriculumPageInfo);
        return "checkAllCurriculum";
    }

    /**
     * 查看所有的选修课
     * @return 信息
     */
    @GetMapping("/toCheckAllLogoCurriculumMessage")
    public String toCheckAllLogoCurriculumMessage(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                                  @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                                  Model model){
        PageInfo<Curriculum> curriculumPageInfo = curriculumService.checkAllChooseCurriculumMessage(pageNum, pageSize, "选修");
        Role.pageLocation = "/toCheckAllLogoCurriculumMessage";
        Role.utilsLogin(model);
        model.addAttribute("status","选修");
        model.addAttribute("zero",Role.classStatus);
        model.addAttribute("studentPageInfo",curriculumPageInfo);
        return "checkAllCurriculum";
    }

    /**
     * 查看学生课程
     * @return 信息
     */
    @GetMapping("/checkStudentCurriculumMessage")
    public String checkStudentCurriculumMessage(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                                @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                                Model model){
        PageInfo<Curriculum> curriculumPageInfo = curriculumService.checkOneStudentCurriculumMessage(pageNum, pageSize, Role.department, "必修");
        Role.pageLocation = "/checkStudentCurriculumMessage";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",curriculumPageInfo);
        return "checkAllCurriculum";
    }

    /**
     * 学生查看自己学的课程
     * @return 信息
     */
    @GetMapping("/studentToCheckAllCurriculumMessage")
    public String studentToCheckAllCurriculumMessage(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                                     @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                                     Model model){
        PageInfo<Curriculum> curriculumPageInfo = curriculumService.checkOneStudentCurriculumMessage(pageNum, pageSize, Role.department, "必修");
        Role.pageLocation = "/studentToCheckAllCurriculumMessage";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",curriculumPageInfo);
        return "checkAllCurriculum";
    }

    @GetMapping("/checkLearnLogoCourseForMeTeacher/{classState}")
    public String checkLearnLogoCourseForMeTeacher(@PathVariable("classState") String classState){
        Curriculum curriculum = curriculumService.checkTeacherMessage(classState);
        Role.teacherDepartment = curriculum.getDepartment();
        Role.teacherName = curriculum.getTeacher();
        return "redirect:/studentCheckTeacherSelfMessage";
    }
}
