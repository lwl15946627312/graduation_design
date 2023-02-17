package com.lwl.controller;

import com.github.pagehelper.PageInfo;
import com.lwl.pojo.Canteen;
import com.lwl.service.impl.CanteenServiceImpl;
import com.lwl.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class CanteenController {

    @Autowired
    CanteenServiceImpl canteenService;

    /**
     * 查看今日菜单 分页
     * @return 菜品信息
     */
    @RequestMapping("/toCheckTodayFoods")
    public String toCheckTodayFoods(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "3")Integer pageSize,
                                    Model model){
        PageInfo<Canteen> canteenPageInfo = canteenService.todayCanteenFood(pageNum,pageSize,"1");
        Role.pageLocation = "/toCheckTodayFoods";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",canteenPageInfo);
        return "todayFood";
    }

    /**
     * 管理员查看全部菜单 分页
     * @return 菜品信息
     */
    @RequestMapping("/toCheckAllFood")
    public String toCheckAllFood(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "3")Integer pageSize,
                                 Model model){
        PageInfo<Canteen> canteenPageInfo = canteenService.queryAllFood(pageNum, pageSize,"0");
        Role.pageLocation = "/toCheckAllFood";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",canteenPageInfo);
        return "adminCheckAllFood";
    }

    /**
     * 管理员添加菜品
     * @return 跳转页面
     */
    @GetMapping("/toAdminAddFoodMessage")
    public String toAdminAddFoodMessage(Model model){
        Role.utilsLogin(model);
        return "adminAddFood";
    }

    /**
     * 管理员添加菜品
     * @return ok
     */
    @PostMapping("/adminAddFoodMessage")
    public String adminAddFoodMessage(Model model, String name, MultipartFile file, String price){
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
        canteenService.adminAddFoodToCanteen(Role.createUUID(),name,newName,price,"0");
        Role.utilsLogin(model);
        return "redirect:/toCheckAllFood";
    }

    /**
     * 查询菜品
     * @return 信息
     */
    @RequestMapping("/adminCheckSomeFoods")
    public String adminCheckSomeFoods(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize",required = false,defaultValue = "3")Integer pageSize,
                                      Model model,String name){
        PageInfo<Canteen> canteenPageInfo = canteenService.queryOneFoodByName(pageNum,pageSize,name);
        Role.pageLocation = "/adminCheckSomeFoods";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",canteenPageInfo);
        return "adminCheckAllFood";
    }

    /**
     * 添加菜品到今日菜单
     * @return ok
     */
    @GetMapping("/adminAddFoodToTodayFoods/{id}")
    public String adminAddFoodToTodayFoods(Model model,@PathVariable("id") String id){
        canteenService.adminDelTodayFood(id,"1");
        Role.utilsLogin(model);
        return "redirect:/toCheckAllFood";
    }

    /**
     *删除菜品
     * @return ok
     */
    @GetMapping("/adminDelFoodMessage/{id}")
    public String adminDelFoodMessage(Model model,@PathVariable("id") String id){
        canteenService.adminDelFoodFromCanteen(id);
        Role.utilsLogin(model);
        return "redirect:/toCheckAllFood";
    }

    /**
     *查看所有食物
     * @return ok
     */
    @RequestMapping("/checkSomeFoods")
    public String checkSomeFoods(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "3")Integer pageSize,
                                 Model model,String name){
        PageInfo<Canteen> canteenPageInfo = canteenService.queryOneFoodByName(pageNum,pageSize,name);
        Role.pageLocation = "/checkSomeFoods";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",canteenPageInfo);
        return "todayFood";
    }

    /**
     * 从今日菜单移除菜品
     * @return ok
     */
    @RequestMapping("/adminToDelFoodMessage/{id}")
    public String adminToDelFoodMessage(@PathVariable("id") String id,Model model){
        canteenService.adminDelTodayFood(id,"0");
        Role.utilsLogin(model);
        return "redirect:/toCheckTodayFoods";
    }

}
