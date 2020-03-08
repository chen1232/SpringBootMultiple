package com.chen.multiple.http;

import model.UserInfo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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

        //headers
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("api-version", "1.0");
        //body
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("roundid", "1");
        //HttpEntity
        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<MultiValueMap>(requestBody, requestHeaders);

        ResponseEntity<UserInfo> userInfoResponseEntity =
                restTemplate.postForEntity("http://localhost:8080/multiple/sys/v1/user/getUserInfo", requestEntity, UserInfo.class);
        UserInfo body = userInfoResponseEntity.getBody();
        return body;
    }
}
