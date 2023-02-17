package com.lwl.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleTest {

    @Test
    public void randomNumberTest(){
        String s = Role.randomNumber(8);
        System.out.println(s.getClass());
    }

    @Test
    public void UUIDTest(){
        for (int i = 0; i < 24; i++) {
            System.out.println(Role.createUUID());
        }
    }
}
