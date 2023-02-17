package com.lwl.mapper;

import com.lwl.pojo.Gymnasium;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GymnasiumMapper {

    /**
     * 查询所有场地
     * @param status 0为被借用 1被借用
     * @return 借用信息
     */
    List<Gymnasium> queryAllGymnasium(String status);

    /**
     * 多条件查询所有的场地
     * @param name 场地名称
     * @param address 场地地址
     * @return 信息
     */
    List<Gymnasium> queryAllGymnasiumByNameOrAddress(String name,String address,String status,String department);

    /**
     * 预定场地
     * @return ok
     */
    int updateGymnasiumMessage(String id,String status,String department,String person,String role);

    /**
     * 查询场地信息
     * @return ok
     */
    Gymnasium queryById(String id);
}
