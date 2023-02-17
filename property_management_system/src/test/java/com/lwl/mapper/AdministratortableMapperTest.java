package com.lwl.mapper;

import com.lwl.pojo.Administratortable;
import com.lwl.service.impl.AdministratortableServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdministratortableMapperTest {

    @Autowired
    AdministratortableServiceImpl administratortableMapper;

    @Test
    public void loginTest() {
        Administratortable login = administratortableMapper.adminLogin("654792", "123456");
        System.out.println(login);
    }

}
