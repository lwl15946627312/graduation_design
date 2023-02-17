package com.lwl.controller;

import com.github.pagehelper.PageInfo;
import com.lwl.pojo.Gymnasium;
import com.lwl.service.impl.GymnasiumServiceImpl;
import com.lwl.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GymnasiumController {

    @Autowired
    GymnasiumServiceImpl gymnasiumService;

    /**
     * 查询全部有位置的场地
     * @return 信息
     */
    @GetMapping("/toCheckGymnasium")
    public String toCheckGymnasium(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                   Model model){
        PageInfo<Gymnasium> gymnasiumPageInfo = gymnasiumService.queryAllGymnasium("0", pageNum, pageSize);
        Role.pageLocation = "/toCheckGymnasium";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",gymnasiumPageInfo);
        return "checkAllGymnasium";
    }

    /**
     *多条件查询全部有位置的场地
     * @return 场地信息
     */
    @PostMapping("/checkSomeGymnasiums")
    public String checkSomeGymnasiums(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                      Model model,String name,String address){
        PageInfo<Gymnasium> gymnasiumPageInfo = gymnasiumService.queryAllGymnasiumByNameOrAddress(pageNum,pageSize,name,address,null,"0");
        Role.pageLocation = "/checkSomeGymnasiums";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",gymnasiumPageInfo);
        return "checkAllGymnasium";
    }

    /**
     * 查询没位置的场地
     * @return 场地信息
     */
    @GetMapping("/toCheckAllGymnasium")
    public String toCheckAllGymnasium(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                      Model model){
        PageInfo<Gymnasium> gymnasiumPageInfo = gymnasiumService.queryAllGymnasium("1", pageNum, pageSize);
        Role.pageLocation = "/toCheckAllGymnasium";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",gymnasiumPageInfo);
        return "adminCheckAllGymnasium";
    }

    /**
     * 多条件的查询没位置的场地
     * @return 场地信息
     */
    @PostMapping("/adminCheckSomeGymnasiums")
    public String adminCheckSomeGymnasiums(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,
                                           Model model,String name,String address,String department){
        PageInfo<Gymnasium> gymnasiumPageInfo = gymnasiumService.queryAllGymnasiumByNameOrAddress(pageNum,pageSize,name,address,department,"1");
        Role.pageLocation = "/adminCheckSomeGymnasiums";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",gymnasiumPageInfo);
        return "adminCheckAllGymnasium";
    }

}
