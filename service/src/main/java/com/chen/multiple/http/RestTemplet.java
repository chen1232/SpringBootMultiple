package com.chen.multiple.http;

import model.UserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author chen
 */
@Component
public class RestTemplet {
    private final RestTemplate restTemplate;

    public RestTemplet(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserInfo get() {
        ResponseEntity<UserInfo> userInfoResponseEntity = restTemplate.postForEntity("http://localhost:8080/multiple/sys/v1/user/getUserInfo", "1", UserInfo.class);
        UserInfo body = userInfoResponseEntity.getBody();
        return body;
    }
}
