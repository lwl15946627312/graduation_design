package com.lwl.controller;

import com.lwl.pojo.Administratortable;
import com.lwl.pojo.Student;
import com.lwl.pojo.Teacher;
import com.lwl.service.impl.AdministratortableServiceImpl;
import com.lwl.service.impl.StudentServiceImpl;
import com.lwl.service.impl.TeacherServiceImpl;
import com.lwl.utils.Role;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    AdministratortableServiceImpl administratortableService;

    @Autowired
    TeacherServiceImpl teacherService;

    @Autowired
    StudentServiceImpl studentService;

    private String username;
    private String password;
    private String role;


    @ApiOperation("登录页")
    @RequestMapping("/")
    public String toLogin() {
        return "login";
    }

    /**
     *  分类从前端传递的角色
     * @param username 用户名
     * @param password 密码
     * @param role 角色
     * @param model 向前端传递信息
     * @return 信息传递到下一个方法
     */
    @ApiOperation("角色分类")
    @RequestMapping("/toLogin")
    public String getLoginMessage(String username,String password,String role,Model model){
        this.username = username;
        this.password = password;
        this.role = role;
        Role.role = role;
        if(role.equals("管理员")){
            return "redirect:/adminLogin";
        }else if(role.equals("教师")){
            return "redirect:/teacherLogin";
        }else if(role.equals("学生")){
            return "redirect:/studentLogin";
        }else{
            model.addAttribute("msg","登录出现异常 请联系管理员");
            return "login";
        }
    }

    /**
     *  管理员登录
     * @param session 信息存入session方便调用
     * @param model 向前端传递信息
     * @return 跳转到正确页面
     */
    @ApiOperation("管理员登录")
    @RequestMapping("/adminLogin")
    public String adminLogin(HttpSession session,Model model){
        Administratortable adminLogin = administratortableService.adminLogin(this.username, this.password);
        if(adminLogin!=null){
            Role.name = adminLogin.getName();
            Role.photoName = adminLogin.getPhoto();
            Role.adminId = adminLogin.getId();
            Role.utilsLogin(model);
            session.setAttribute("login",adminLogin);
            return "index";
        }else{
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }
    }

    /**
     *  教师登录
     * @param session 信息存入session方便调用
     * @param model 向前端传递信息
     * @return 跳转到正确页面
     */
    @ApiOperation("教师登录")
    @RequestMapping("/teacherLogin")
    public String teacherLogin(HttpSession session,Model model){
        Teacher teacherLogin = teacherService.teacherLogin(this.username, this.password);
        if(teacherLogin!=null){
            Role.name = teacherLogin.getName();
            Role.photoName = teacherLogin.getPhoto();
            Role.department = teacherLogin.getDepartment();
            Role.id = teacherLogin.getId();
            Role.utilsLogin(model);
            session.setAttribute("login",teacherLogin);
            return "index";
        }else{
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }
    }

    /**
     *  学生登录
     * @param session 信息存入session方便调用
     * @param model 向前端传递信息
     * @return 跳转到正确页面
     */
    @ApiOperation("学生登录")
    @RequestMapping("/studentLogin")
    public String studentLogin(HttpSession session,Model model){
        Student studentLogin = studentService.studentLogin(this.username, this.password);
        if(studentLogin!=null){
            Role.name = studentLogin.getName();
            Role.photoName = studentLogin.getPhoto();
            Role.department = studentLogin.getDepartment();
            Role.id = studentLogin.getId();
            Role.classStatus = studentLogin.getClassState();
            Role.utilsLogin(model);
            session.setAttribute("login",studentLogin);
            return "index";
        }else{
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }
    }

    /**
     *  退出登录
     * @param request 获取session
     * @return 登录界面
     */
    @ApiOperation("退出登录")
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request){
        if (this.role=="管理员"){
            request.getSession().removeAttribute("login");
            return "redirect:/";
        }else if(this.role=="教师"){
            request.getSession().removeAttribute("login");
            return "redirect:/";
        }else{
            request.getSession().removeAttribute("login");
            return "redirect:/";
        }
    }

    /**
     * 分发查看个人信息的请求
     * @return 跳转
     */
    @GetMapping("/personalCenter")
    public String personalCenter(Model model){
        if(Role.role.equals("管理员")){
            return "redirect:/adminPersonalCenter";
        }else if(Role.role.equals("教师")){
            return "redirect:/teacherPersonalCenter";
        }else if(Role.role.equals("学生")){
            return "redirect:/studentPersonalCenter";
        }else {
            Role.utilsLogin(model);
            return "index";
        }
    }

    /**
     * 管理员查看个人信息
     * @return 信息
     */
    @GetMapping("/adminPersonalCenter")
    public String adminPersonalCenter(Model model){
        Administratortable administratortable = administratortableService.checkSelfMessage(Role.adminId);
        Role.utilsLogin(model);
        model.addAttribute("selfMessage",administratortable);
        return "adminPersonalCenter";
    }

    /**
     * 教师查看个人信息
     * @return 信息
     */
    @GetMapping("/teacherPersonalCenter")
    public String teacherPersonalCenter(Model model){
        Teacher teacher = teacherService.checkSelfMessage(Role.id);
        Role.utilsLogin(model);
        model.addAttribute("selfMessage",teacher);
        return "teacherPersonalCenter";
    }

    /**
     * 学生查看个人信息
     * @return 信息
     */
    @GetMapping("/studentPersonalCenter")
    public String studentPersonalCenter(Model model){
        Student student = studentService.checkSelfMessage(Role.id);
        Role.utilsLogin(model);
        model.addAttribute("selfMessage",student);
        return "studentPersonalCenter";
    }

    /**
     * 跳转到更改
     * @return 信息
     */
    @GetMapping("/toUpdatePassword")
    public String toUpdatePassword(Model model){
        Role.utilsLogin(model);
        return "updatePassword";
    }

    /**
     * 更改密码
     * @return ok
     */
    @GetMapping("/allRoleUpdatePassword")
    public String allRoleUpdatePassword(String oldName,String newName01,String newName02,Model model){
        if(Role.role.equals("管理员")){
            Administratortable administratortable = administratortableService.checkSelfMessage(Role.adminId);
            String password = administratortable.getPassword();
            boolean p1 = (password==oldName);
            boolean p2 = (newName01==newName02);
            if((p1==p2) && (password!=newName01) ){
                administratortableService.adminUpdateMessage(Role.adminId,newName01);
                return "redirect:/exit";
            }else {
                Role.utilsLogin(model);
                model.addAttribute("msg","密码错误");
                return "updatePassword";
            }

        }else if(Role.role.equals("教师")){
            Teacher teacher = teacherService.checkSelfMessage(Role.id);
            String password = teacher.getPassword();
            boolean p1 = (password==oldName);
            boolean p2 = (newName01==newName02);
            if((p1==p2) && (password!=newName01) ){
                teacherService.teacherUpdatePassword(Role.id,newName01);
                return "redirect:/exit";
            }else {
                Role.utilsLogin(model);
                model.addAttribute("msg","密码错误");
                return "updatePassword";
            }
        }else if(Role.role.equals("学生")){
            Student student = studentService.checkSelfMessage(Role.id);
            String password = student.getPassword();
            boolean p1 = (password==oldName);
            boolean p2 = (newName01==newName02);
            if((p1==p2) && (password!=newName01) ){
                studentService.studentUpdatePassword(Role.id,newName01);
                return "redirect:/exit";
            }else {
                Role.utilsLogin(model);
                model.addAttribute("msg","密码错误");
                return "updatePassword";
            }
        }else {
            return "redirect:/exit";
        }
    }

    /**
     * 管理员更改头像
     * @return ok
     */
    @PostMapping("/adminUpdatePhoto")
    public String adminUpdatePhoto(MultipartFile file, Model model){
        //图片校验（图片是否为空,图片大小，上传的是不是图片、图片类型（例如只能上传png）等等）
        if (file.isEmpty()) {
            return null;
        }
        //可以自己加一点校验 例如上传的是不是图片或者上传的文件是不是png格式等等 这里省略
        //获取原来的文件名和后缀
        String originalFilename = file.getOriginalFilename();
        //String ext = "." + FilenameUtils.getExtension(orgFileName); --需要导依赖
        String ext = "."+ originalFilename.split("\\.")[1];
        //生成一个新的文件名（以防有重复的名字存在导致被覆盖）
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String newName = uuid + ext;
        //拼接图片上传的路径 url+图片名
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());
        String pre = applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath() + "\\src\\main\\resources\\static\\img\\";
        String path = pre + newName;
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        administratortableService.adminUploadPhoto(Role.adminId,newName);
        Role.utilsLogin(model);
        return "redirect:/adminPersonalCenter";
    }

    /**
     * 教师更改头像
     * @return ok
     */
    @PostMapping("/teacherUpdatePhoto")
    public String teacherUpdatePhoto(MultipartFile file, Model model){
        //图片校验（图片是否为空,图片大小，上传的是不是图片、图片类型（例如只能上传png）等等）
        if (file.isEmpty()) {
            return null;
        }
        //可以自己加一点校验 例如上传的是不是图片或者上传的文件是不是png格式等等 这里省略
        //获取原来的文件名和后缀
        String originalFilename = file.getOriginalFilename();
        //String ext = "." + FilenameUtils.getExtension(orgFileName); --需要导依赖
        String ext = "."+ originalFilename.split("\\.")[1];
        //生成一个新的文件名（以防有重复的名字存在导致被覆盖）
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String newName = uuid + ext;
        //拼接图片上传的路径 url+图片名
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());
        String pre = applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath() + "\\src\\main\\resources\\static\\img\\";
        String path = pre + newName;
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        teacherService.teacherUploadPhoto(Role.id,newName);
        Role.utilsLogin(model);
        return "redirect:/teacherPersonalCenter";
    }

    /**
     * 学生更改头像
     * @return ok
     */
    @PostMapping("/studentUpdatePhoto")
    public String studentUpdatePhoto(MultipartFile file, Model model){
        //图片校验（图片是否为空,图片大小，上传的是不是图片、图片类型（例如只能上传png）等等）
        if (file.isEmpty()) {
            return null;
        }
        //可以自己加一点校验 例如上传的是不是图片或者上传的文件是不是png格式等等 这里省略
        //获取原来的文件名和后缀
        String originalFilename = file.getOriginalFilename();
        //String ext = "." + FilenameUtils.getExtension(orgFileName); --需要导依赖
        String ext = "."+ originalFilename.split("\\.")[1];
        //生成一个新的文件名（以防有重复的名字存在导致被覆盖）
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String newName = uuid + ext;
        //拼接图片上传的路径 url+图片名
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());
        String pre = applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath() + "\\src\\main\\resources\\static\\img\\";
        String path = pre + newName;
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        studentService.studentUploadPhoto(Role.id,newName);
        Role.utilsLogin(model);
        return "redirect:/studentPersonalCenter";
    }

    /**
     * 借书
     * @return ok
     */
    @GetMapping("/borrowBook/{bookName}")
    public String borrowBook(@PathVariable("bookName") String bookName,Model model){
        studentService.studentBorrowBook(Role.id,bookName);
        Role.utilsLogin(model);
        return "redirect:/studentPersonalCenter";
    }

    /**
     * 还书
     * @return ok
     */
    @GetMapping("/returnBook")
    public String returnBook(Model model){
        studentService.studentBorrowBook(Role.id,"没借");
        Role.utilsLogin(model);
        return "redirect:/toCheckAllBooks";
    }

}


