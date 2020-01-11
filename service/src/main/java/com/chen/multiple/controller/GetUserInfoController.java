package com.chen.multiple.controller;

import com.chen.multiple.http.RestTemplet;
import model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chen
 */
@RestController
@RequestMapping(value = "/multiple/sys/v1/user")
public class GetUserInfoController {

    @Autowired
    private RestTemplet restTemplet;

    @PostMapping(value = "/getUserInfo")
    public UserInfo getUserInfo(HttpServletRequest request) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("chen");
        userInfo.setAge("18");
        userInfo.setSex("man");
        userInfo.setId("1");
        return userInfo;
    }

    @PostMapping(value = "/test")
    public UserInfo test() {
        UserInfo userInfo = restTemplet.get();
        return userInfo;
    }
}
