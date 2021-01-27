package com.chris.vueblog.controller;

import com.chris.vueblog.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/id")
    public Object test() {
        System.out.println("========");
        return userServiceImpl.selectByPrimaryKey(1L);
    }
}
