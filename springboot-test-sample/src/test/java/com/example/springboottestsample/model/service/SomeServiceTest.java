package com.example.springboottestsample.model.service;

import com.example.springboottestsample.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class SomeServiceTest {

    @Mock
    private IUserService userService;

    @Before
    public void setup(){
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setName("john");
        mockUser.setCreateTime(new Date());
        when(userService.findOne(1L)).thenReturn(mockUser);
    }

    @Test
    public void findOneTest(){
        User user = userService.findOne(1L);
        log.info("user.name = {}", user.getName());
        Assert.assertEquals(user.getName(), "john");
    }
}