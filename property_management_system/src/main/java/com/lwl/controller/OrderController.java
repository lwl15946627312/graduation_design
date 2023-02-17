package com.lwl.controller;

import com.github.pagehelper.PageInfo;
import com.lwl.mapper.CanteenMapper;
import com.lwl.pojo.Canteen;
import com.lwl.pojo.Order;
import com.lwl.service.impl.OrderServiceImpl;
import com.lwl.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    CanteenMapper canteenMapper;

    /**
     * 查询所有订餐信息
     * @return 信息
     */
    @GetMapping("/toCheckOrderMessage")
    public String toCheckOrderMessage(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize",required = false,defaultValue = "9")Integer pageSize,
                                      Model model){
        PageInfo<Order> orderPageInfo = orderService.queryAllOrderMessage(pageNum, pageSize);
        Role.pageLocation = "/toCheckOrderMessage";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",orderPageInfo);
        return "checkAllOrder";
    }

    /**
     * 多条件查询订单信息
     * @return 信息
     */
    @GetMapping("/checkSomeOrders")
    public String CheckSomeOrders(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize",required = false,defaultValue = "9")Integer pageSize,
                                  Model model,String foodName,String department,String role){
        PageInfo<Order> orderPageInfo = orderService.querySomeOrderMessage(pageNum, pageSize, department,role,foodName);
        Role.pageLocation = "/checkSomeOrders";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",orderPageInfo);
        return "checkAllOrder";
    }

    /**
     * 订餐
     * @return ok
     */
    @GetMapping("/orderFood/{id}")
    public String orderFood(@PathVariable("id") String id,Model model){
        Canteen canteen = canteenMapper.checkOneFoodById(id);
        orderService.addOrderMessage(Role.createUUID(),Role.name,canteen.getName(),canteen.getPrice(),Role.role,Role.department,canteen.getPhoto());
        Role.utilsLogin(model);
        return "redirect:/toCheckTodayFoods";
    }

    /**
     * 删除
     * @return ok
     */
    @GetMapping("/delOrder/{id}")
    public String delOrder(@PathVariable("id") String id, Model model){
        orderService.delOrderMessage(id);
        Role.utilsLogin(model);
        return "redirect:/toCheckOrderMessage";
    }

    /**
     * 查看自己的菜单
     * @return 信息
     */
    @GetMapping("/checkAllOrderMessage")
    public String returnGymnasium(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize",required = false,defaultValue = "3")Integer pageSize,
                                  Model model){
        PageInfo<Order> orderPageInfo = orderService.querySelfOrderMessage(pageNum, pageSize, Role.name, Role.role, Role.department);
        Role.pageLocation = "/checkAllOrderMessage";
        Role.utilsLogin(model);
        model.addAttribute("studentPageInfo",orderPageInfo);
        return "selfOrderMessage";
    }
}
