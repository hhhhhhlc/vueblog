package com.chris.vueblog.controller;


import cn.hutool.core.map.MapUtil;
import com.chris.vueblog.common.Result;
import com.chris.vueblog.entity.User;
import com.chris.vueblog.service.impl.UserServiceImpl;
import com.chris.vueblog.util.jwtUtil.JwtUtils;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpServletResponse response) {
        User user1 = userServiceImpl.findUserByName(user);
        if (user1.getPassword().equals(user.getPassword())) {
            // 查询到人，那么jwt
            String jwt = jwtUtils.createToken(user1.getId());
            response.setHeader("Authorization", jwt);
            response.setHeader("Access-control-Expose-Headers", "Authorization");

            return Result.succ(MapUtil.builder()
                    .put("id", user1.getId())
                    .put("username", user1.getUsername())
                    .put("avatar", user1.getAvatar())
                    .put("email", user1.getEmail())
                    .map());
        }

        return Result.fail(null);

    }
}
