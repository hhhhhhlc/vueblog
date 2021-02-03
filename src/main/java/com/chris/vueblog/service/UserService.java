package com.chris.vueblog.service;

import com.chris.vueblog.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author clh
 * @since 2021-01-28
 */
public interface UserService extends IService<User> {

    public User findUserByName(User user);
}
