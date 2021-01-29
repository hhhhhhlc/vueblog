package com.chris.vueblog.controller;


import com.chris.vueblog.common.Result;
import com.chris.vueblog.entity.User;
import com.chris.vueblog.service.UserService;
import com.chris.vueblog.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author clh
 * @since 2021-01-28
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/login")
    public Result login(User user) {
        boolean res = userServiceImpl.findUserByName(user);
        if (res) {
            Result.succ(null);
        }
        return Result.fail(null);

    }
}
