package com.lwl.controller;

import com.github.pagehelper.PageInfo;
import com.lwl.pojo.Gymnasium;
import com.lwl.pojo.Student;
import com.lwl.pojo.StudentId;
import com.lwl.pojo.Teacher;
import com.lwl.service.impl.GymnasiumServiceImpl;
import com.lwl.service.impl.StudentIdServiceImpl;
import com.lwl.service.impl.StudentServiceImpl;
import com.lwl.service.impl.TeacherServiceImpl;
import com.lwl.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdministratortableController {

    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    TeacherServiceImpl teacherService;

    @Autowired
    GymnasiumServiceImpl gymnasiumService;

    @Autowired
    StudentIdServiceImpl studentIdService;

    /**
     * 跳转到查询全部学生页面
     * @param model 向页面传递信息
     * @return 跳转
     */
    @RequestMapping("/toCheckAllStudent")
    public String toCheckAllStudent(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "9")Integer pageSize,
                                    Model model){
        PageInfo<Student> studentPageInfo = studentService.queryAllStudent(pageNum, pageSize);
        Role.pageLocation = "/toCheckAllStudent";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",studentPageInfo);
        return "checkAllStudent";
    }

    /**
     *多条件查询学生
     * @return 学生信息
     */
    @RequestMapping("/adminCheckSomeStudent")
    public String adminCheckSomeStudent(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                        @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                        String department,String studentClass,String name,Model model){
        PageInfo<Student> studentPageInfo = studentService.selectSomeStudentByDepartmentOrStudentClassOrName(pageNum, pageSize, department, studentClass, name);
        Role.pageLocation = "/adminCheckSomeStudent";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",studentPageInfo);
        return "checkAllStudent";
    }

    /**
     * 返回查询全部学生页面
     * @return 页面跳转
     */
    @GetMapping("/returnIndex")
    public String returnAdminAddStudent(Model model){
        Role.utilsLogin(model);
        return "index";
    }

    /**
     * 跳转到注册学生页面
     * @return 页面跳转
     */
    @GetMapping("/toAdminAddStudent")
    public String toAdminAddStudent(Model model){
        Role.utilsLogin(model);
        return "adminAddStudent";
    }

    /**
     * 注册学生
     * @return 注册成功返回到查询所有学生页面
     */
    @PostMapping("/adminAddStudent")
    public String adminAddStudent(Model model,String name, String password, String sex, String dataOfBirth, String IdNumber, String phone, String email, String address,
                                  String studentNumber, String department, String studentClass, String birthplace, String admissionTime, String dorm){
        studentService.addStudent(Role.createUUID(),name,password,sex,dataOfBirth,IdNumber,phone,email,address,studentNumber,department,studentClass,
                birthplace,admissionTime,"null",dorm,"a","没选","0", Role.student);
        Role.utilsLogin(model);
        return "redirect:/toCheckAllStudent";
    }

    /**
     * 查找到选定的学生
     * @param id 学生id
     * @param model 向前端传递信息
     * @return 跳转页面
     */
    @GetMapping("/adminToUpdateStudentMessage/{id}")
    public String adminToUpdateStudentMessage(@PathVariable("id") String id, Model model){
        Student student = studentService.checkOneStudentById(id);
        model.addAttribute("student",student);
        Role.utilsLogin(model);
        return "adminUpdateStudentMessage";
    }

    /**
     * 修改学生
     * @return 跳转页面
     */
    @PostMapping("/adminUpdateStudent")
    public String adminUpdateStudent(String id,String name, String password, String dataOfBirth, String IdNumber, String phone, String email, String address,
                                     String studentNumber, String department, String studentClass, String birthplace, String admissionTime, String dorm){
        studentService.adminUpdateStudent(id,name,password,dataOfBirth,IdNumber,phone,email,address,studentNumber,department,studentClass,
                birthplace,admissionTime,dorm,"a","0","0", Role.student);
        return "redirect:/toCheckAllStudent";
    }

    /**
     * 删除学生
     * @param id 学生id
     * @return ok
     */
    @GetMapping("/adminDelStudentMessage/{id}")
    public String adminDelStudentMessage(@PathVariable("id") String id){
        studentService.adminDelStudent(id);
        return "redirect:/toCheckAllStudent";
    }

    /**
     * 以分页查询所有教师
     * @return 教师信息
     */
    @RequestMapping("/adminCheckAllTeacher")
    public String adminCheckAllStudent(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                       Model model){
        PageInfo<Teacher> teacherPageInfo = teacherService.adminCheckAllTeacher(pageNum, pageSize);
        Role.pageLocation = "/adminCheckAllTeacher";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",teacherPageInfo);
        return "adminCheckAllTeacher";
    }

    /**
     * 多条件查询教师信息
     * @return 教师信息
     */
    @RequestMapping("/adminCheckSomeTeacher")
    public String adminCheckSomeTeacher(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                        @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                        Model model,String department,String name){
        PageInfo<Teacher> teacherPageInfo = teacherService.adminCheckAllTeacherByDepartmentOrName(pageNum, pageSize, department, name);
        Role.pageLocation = "/adminCheckSomeTeacher";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",teacherPageInfo);
        return "adminCheckAllTeacher";
    }

    /**
     * 跳转到添加教师页面
     * @param model 传递信息
     * @return ok
     */
    @GetMapping("/toAdminAddTeacherMessage")
    public String toAdminAddTeacherMessage(Model model){
        Role.utilsLogin(model);
        return "adminAddTeacher";
    }

    /**
     * 管理员添加教师
     * @return ok
     */
    @PostMapping("/adminAddTeacherMessage")
    public String adminAddTeacherMessage(String id,String name,String password,String sex,
                                         String dataOfBirth,String IdNumber,String phone,
                                         String email,String address,String studentNumber,
                                         String department,String studentClass,String birthplace,
                                         String admissionTime,String photo,String dorm,String evaluate,
                                         String classState,String bookState,String perms,Model model){
        teacherService.adminAddTeacherMessage(Role.createUUID(),"null",department,name,sex,phone,email,
                                                Role.randomNumber(8),password,Role.teacher);
        Role.utilsLogin(model);
        return "redirect:/adminCheckAllTeacher";
    }

    /**
     * 跳转到修改教师的页面
     * @return 跳转
     */
    @GetMapping("/adminToUpdateTeacherMessage/{id}")
    public String adminToUpdateTeacherMessage(Model model,@PathVariable("id") String id){
        Teacher teacher = teacherService.adminCheckOneStudentById(id);
        Role.utilsLogin(model);
        model.addAttribute("teacher",teacher);
        return "adminUpdateTeacher";
    }

    /**
     *修改教师信息
     * @return ok
     */
    @PostMapping("/adminUpdateTeacherMessage")
    public String adminUpdateTeacherMessage(Model model,String id,String name,String password,String phone,String email,String department){
        teacherService.adminUpdateTeacherMessage(id,department,name,phone,email,password,Role.teacher);
        Role.utilsLogin(model);
        return "redirect:/adminCheckAllTeacher";
    }

    /**
     *删除教师信息
     * @return ok
     */
    @GetMapping("/adminDelTeacherMessage/{id}")
    public String adminDelTeacherMessage(Model model,@PathVariable("id") String id){
        teacherService.adminDelTeacher(id);
        Role.utilsLogin(model);
        return "redirect:/adminCheckAllTeacher";
    }

    @GetMapping("/studentCheckTeacherSelfMessage")
    public String StudentCheckTeacherSelfMessage(Model model){
        Teacher teacher = teacherService.queryTeacherId(Role.teacherDepartment, Role.teacherName);
        Role.utilsLogin(model);
        model.addAttribute("teacher",teacher);
        return "studentCheckTeacherMessage";
    }

    /**
     *  预定体育场
     * @return ok
     */
    @GetMapping("/orderGymnasium/{id}")
    public String orderGymnasium(@PathVariable("id") String id,Model model){
        studentIdService.addMessage(Role.id,id);
        gymnasiumService.updateGymnasiumMessage(id,"1",Role.department,Role.name,Role.role);
        Gymnasium gymnasium = gymnasiumService.queryById(id);
        String name = gymnasium.getName();
        String address = gymnasium.getAddress();
        String message = name+":"+address;
        studentService.updateEvaluateMessage(message,Role.id);
        Role.utilsLogin(model);
        return "redirect:/toCheckGymnasium";
    }

    /**
     * 退订
     * @return ok
     */
    @GetMapping("/returnGymnasium")
    public String returnGymnasium(){
        StudentId studentId = studentIdService.queryOneMessage(Role.id);
        studentService.updateEvaluateMessage("没订",studentId.getStudentId());
        gymnasiumService.updateGymnasiumMessage(studentId.getGymnasiumId(),"0","没人订","没人订","没人订");
        studentIdService.delOne(Role.id);
        return "redirect:/studentPersonalCenter";
    }
}
