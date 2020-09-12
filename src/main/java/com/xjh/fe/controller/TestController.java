package com.xjh.fe.controller;

import com.xjh.fe.model.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
public class TestController {
    @Resource
    private User user;
    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    @ResponseBody
    public User hello(String uid){
        user.setAge(11);
        user.setNickname("jason");
        user.setUid(uid);
        return user;
    }
}
