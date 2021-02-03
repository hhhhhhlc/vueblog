package com.chris.vueblog.service.impl;

import com.chris.vueblog.entity.User;
import com.chris.vueblog.mapper.BlogMapper;
import com.chris.vueblog.mapper.UserMapper;
import com.chris.vueblog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author clh
 * @since 2021-01-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    public User findUserByName(User user) {

        return userMapper.findUserByName(user.getUsername());

    }
}
