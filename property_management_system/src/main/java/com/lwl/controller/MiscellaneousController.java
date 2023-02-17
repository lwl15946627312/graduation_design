package com.lwl.controller;

import com.github.pagehelper.PageInfo;
import com.lwl.pojo.Miscellaneous;
import com.lwl.service.impl.MiscellaneousServiceImpl;
import com.lwl.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MiscellaneousController {

    @Autowired
    MiscellaneousServiceImpl miscellaneousService;

    /**
     * 查询自己的写的
     * @return 信息
     */
    @GetMapping("/toCheckMiscellaneous")
    public String toCheckMiscellaneous(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                       Model model){
        PageInfo<Miscellaneous> miscellaneousPageInfo = miscellaneousService.querySelfMiscellaneousByLogo(pageNum,pageSize,"0",Role.name,Role.role);
        Role.pageLocation = "/toCheckMiscellaneous";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",miscellaneousPageInfo);
        return "checkAllMiscellaneous";
    }

    /**
     * 跳转到添加
     * @return 跳转
     */
    @GetMapping("/toAddMiscellaneousMessage")
    public String toAddMiscellaneousMessage(Model model){
        Role.utilsLogin(model);
        return "addMiscellaneous";
    }

    /**
     * 添加通知
     * @return ok
     */
    @PostMapping("/addMiscellaneousMessage")
    public String addMiscellaneousMessage(Model model,String name,String department,String look){
        if(Role.role == "管理员"){
            Role.name = "admin";
        }
        miscellaneousService.addMiscellaneousMessage(Role.createUUID(),name,department,"0",Role.role,Role.name,look);
        Role.utilsLogin(model);
        return "redirect:/toCheckMiscellaneous";
    }

    /**
     * 管理员查看所有信息
     * @return 信息
     */
    @GetMapping("/adminToCheckMiscellaneousMessage")
    public String adminToCheckMiscellaneousMessage(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                                   @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                                   Model model){
        PageInfo<Miscellaneous> miscellaneousPageInfo = miscellaneousService.adminQueryAllMiscellaneous(pageNum, pageSize, "0");
        Role.pageLocation = "/adminToCheckMiscellaneousMessage";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",miscellaneousPageInfo);
        return "adminToCheckAllMiscellaneous";
    }

    /**
     * 管理员查询已解决的信息 分页
     * @return 信息
     */
    @GetMapping("/checkAllResolvedMessage")
    public String checkAllResolvedMessage(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                          @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                          Model model){
        PageInfo<Miscellaneous> miscellaneousPageInfo = miscellaneousService.adminQueryAllMiscellaneous(pageNum, pageSize, "1");
        Role.pageLocation = "/checkAllResolvedMessage";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",miscellaneousPageInfo);
        return "adminToCheckAllMiscellaneous";
    }

    /**
     * 多条件查询信息 分页
     * @return 信息
     */
    @PostMapping("/checkSomeMiscellaneous")
    public String checkSomeMiscellaneous(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                         Model model,String department,String createPerson){
        PageInfo<Miscellaneous> miscellaneousPageInfo = miscellaneousService.querySomeMiscellaneousByNameDepartment(pageNum, pageSize, createPerson, department);
        Role.pageLocation = "/checkSomeMiscellaneous";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",miscellaneousPageInfo);
        return "adminToCheckAllMiscellaneous";
    }

    /**
     * 收到的信息
     * @return 信息
     */
    @GetMapping("/toCheckReceivedMiscellaneousMessage")
    public String toCheckReceivedMiscellaneousMessage(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                                      Model model){
        if(Role.role == "管理员"){
            Role.department = null;
        }
        PageInfo<Miscellaneous> miscellaneousPageInfo = miscellaneousService.queryReceivedMiscellaneousByLogo(pageNum, pageSize, "0", Role.department, Role.role);
        Role.pageLocation = "/toCheckReceivedMiscellaneousMessage";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",miscellaneousPageInfo);
        return "checkAllMiscellaneous";
    }

    /**
     * 已解决
     * @return ok
     */
    @GetMapping("/resolved/{id}")
    public String resolved(@PathVariable("id") String id, Model model){
        miscellaneousService.updateMiscellaneous(id,"1");
        Role.utilsLogin(model);
        return "redirect:/toCheckMiscellaneous";
    }

    /**
     * 删除
     * @return ok
     */
    @GetMapping("/delMiscellaneous/{id}")
    public String delMiscellaneous(@PathVariable("id") String id,Model model){
        miscellaneousService.delMiscellaneousMessage(id);
        Role.utilsLogin(model);
        return "redirect:/toCheckMiscellaneous";
    }

}
