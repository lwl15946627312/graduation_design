package com.lwl.service;

import com.github.pagehelper.PageInfo;
import com.lwl.pojo.Miscellaneous;

public interface MiscellaneousService {

    /**
     * 管理员查询所有的通知 分页
     * @return
     */
    PageInfo<Miscellaneous> adminQueryAllMiscellaneous(Integer pageNum,Integer pageSize,String logo);

    /**
     * 学生和教师查询的查询自己提交的的没有被解决的通知 和收到的通知 分页
     * @param logo 标识
     * @return 信息
     */
    PageInfo<Miscellaneous> querySelfMiscellaneousByLogo(Integer pageNum,Integer pageSize,String logo, String createPerson,String identity);

    /**
     * 查询收到的通知 分页
     * @return 信息
     */
    PageInfo<Miscellaneous> queryReceivedMiscellaneousByLogo(Integer pageNum,Integer pageSize,String logo, String department, String look);

    /**
     * 多条件查询 分页
     * @return 信息
     */
    PageInfo<Miscellaneous> querySomeMiscellaneousByNameDepartment(Integer pageNum,Integer pageSize,String createPerson,String department);

    /**
     * 已解决
     * @return ok
     */
    int updateMiscellaneous(String id,String logo);

    /**
     * 添加通知
     * @return ok
     */
    int addMiscellaneousMessage(String id,String name,String department,String logo,String identity,String createPerson,String look);

    /**
     * 删除信息
     * @return ok
     */
    int delMiscellaneousMessage(String id);

}
