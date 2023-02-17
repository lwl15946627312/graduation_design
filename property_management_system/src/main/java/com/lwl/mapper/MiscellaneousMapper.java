package com.lwl.mapper;

import com.lwl.pojo.Miscellaneous;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface MiscellaneousMapper {

    /**
     * 管理员查询所有的通知
     * @return 信息
     */
    List<Miscellaneous> adminQueryAllMiscellaneous(String logo);

    /**
     * 学生和教师查询的查询自己提交的的没有被解决的通知 和收到的通知
     * @param logo 标识
     * @return 信息
     */
    List<Miscellaneous> querySelfMiscellaneousByLogo(String logo,String createPerson,String identity);

    /**
     * 多条件查询通知
     * @return 信息
     */
    List<Miscellaneous> querySomeMiscellaneousByNameDepartment(String createPerson,String department);

    /**
     *  查看收到的通知
     * @return 通知的信息
     */
    List<Miscellaneous> queryReceivedMiscellaneousByLogo(String logo,String look,String department);

    /**
     * 添加通知
     * @return ok
     */
    int addMiscellaneousMessage(String id,String name,String department,String logo,String identity,String createPerson,String look);

    /**
     * 已解决
     * @return ok
     */
    int updateMiscellaneous(String id,String logo);

    /**
     * 删除信息
     * @return ok
     */
    int delMiscellaneousMessage(String id);

}
