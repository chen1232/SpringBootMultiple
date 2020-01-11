package com.chen.multiple.BeanTest;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import model.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@SpringBootTest
public class UserInfoTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() {
        UserInfo userInfo = new UserInfo();
        String response = "UserInfo(name=chen, age=18, sex=man)";
        userInfo.setName("chen");
        userInfo.setAge("18");
        userInfo.setSex("man");
        log.info("这个用户的姓名是：{}，年龄：{}，性别：{}", userInfo.getName(), userInfo.getAge(), userInfo.getSex());
        Assert.assertEquals(response, userInfo.toString());
    }

    @SneakyThrows
    @Test
    public void testGetUserInfo() {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/multiple/sys/v1/user/getUserInfo"))//执行请求
                .andExpect(status().isOk()).andReturn();

        String response = "{\"name\":\"chen\",\"age\":\"18\",\"sex\":\"man\",\"id\":\"1\"}";
        Assert.assertEquals(response, mvcResult.getResponse().getContentAsString());
    }
}
