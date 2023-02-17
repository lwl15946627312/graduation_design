package com.lwl.utils;

import org.springframework.ui.Model;
import java.util.Random;
import java.util.UUID;

public class Role {

    public static String role = null;


    public static String admin = "all";
    public static String teacher = "th";
    public static String student = "stu";

    public static String photoName = null;
    public static String name = null;

    public static String pageLocation = null;
    public static String department = null;

    public static String logo = null;

    public static String id = null;
    public static int adminId = 0;
    public static String classStatus = null;

    public static String teacherName = null;
    public static String teacherDepartment = null;

    /**
     *  赋值工号
     * @param len 工号长度
     * @return String类型的字符串
     */
    public static String randomNumber(int len){
        StringBuilder str=new StringBuilder();//定义变长字符串
        Random random=new Random();
        //随机生成数字，并添加到字符串
        for(int i=0;i<len;i++){
            str.append(random.nextInt(10));
        }
        //将字符串转换为数字并输出
        int num=Integer.parseInt(str.toString());
        System.out.println(num);
        return num+"";
    }

    /**
     * 赋值id
     * @return uuid
     */
    public static String createUUID(){
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replaceAll("\\-", "");
        return id;
    }

    /**
     * 生成登录信息的工具
     * @return html 公共部分需要的字段
     */
    public static void utilsLogin(Model model){
        model.addAttribute("login",name);
        model.addAttribute("photo",photoName);
        model.addAttribute("role",role);
        model.addAttribute("local",pageLocation);
    }

}

