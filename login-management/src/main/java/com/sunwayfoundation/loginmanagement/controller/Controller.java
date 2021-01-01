package com.sunwayfoundation.loginmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@Slf4j
@RestController
public class Controller {
    @GetMapping("/")
    public String helloWorld() {
        return "you don't need to be logged in";
    }

    @GetMapping("/not-restricted")
    public String notRestricted() {
        return "you don't need to be logged in";
    }

    @GetMapping("/restricted")
    public String restricted() {
        return "if you see this you are logged in";
    }

    @GetMapping("/user/me")
    public String userDetails(@AuthenticationPrincipal OAuth2User user) {

        JSONObject jsonObj = new JSONObject(user.getAttributes());
        log.info("Successfully Authenticate in Gmail");
        log.info("Geeting user name  : "+jsonObj.getAsString("name"));
        log.info("Geeting user name  : "+jsonObj.getAsString("email"));

        return "Successfully Authenticate user will direct to another page";
    }
}
