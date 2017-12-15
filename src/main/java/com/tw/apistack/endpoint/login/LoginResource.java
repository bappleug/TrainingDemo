package com.tw.apistack.endpoint.login;

import com.tw.apistack.endpoint.login.dto.Login;
import com.tw.apistack.endpoint.login.dto.Session;
import com.tw.apistack.endpoint.todo.dto.ResourceWithUrl;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * Created by jxzhong on 2017/7/3.
 */
@RestController
@RequestMapping(value = "/login_exam")
public class LoginResource {

    @PostMapping(headers = {"Content-type=application/json"})
    public HttpEntity<ResourceWithUrl> login(@RequestBody Login login) {
        if(!"admin@thoughtworks.com".equals(login.getUserName()) ||
                !"666".equals(login.getPassword())){

            ResourceWithUrl resourceWithUrl = new ResourceWithUrl<Login>(
                    "account or password error",
                    401,
                    login,
                    "");
            ResponseEntity<ResourceWithUrl> resourceWithUrlResponseEntity =
                    new ResponseEntity<>(resourceWithUrl, UNAUTHORIZED);
            return resourceWithUrlResponseEntity;
        }
        ResponseEntity resourceWithUrlResponseEntity = ResponseEntity.ok(new Session("12345abcde"));
        return resourceWithUrlResponseEntity;
    }

}
