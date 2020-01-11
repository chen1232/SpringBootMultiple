package com.chen.multiple.BeanTest;

import lombok.extern.slf4j.Slf4j;
import model.UserInfo;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class UserInfoTest {
    //    @Autowired
//    @Qualifier("testImpl2")
//    ITestServer iTestServer;

    @Test
    public void test() {
        UserInfo userInfo = new UserInfo();
        String response = "UserInfo(name=chen, age=18, sex=man)";
        userInfo.setName("chen");
        userInfo.setAge("18");
        userInfo.setSex("man");
        log.info("这个用户的姓名是：{}，年龄：{}，性别：{}", userInfo.getName(), userInfo.getAge(), userInfo.getSex());
        Assert.assertEquals(response,userInfo.toString());
    }
}
