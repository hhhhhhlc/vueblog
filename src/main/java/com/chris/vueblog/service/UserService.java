package com.chris.vueblog.service;


import com.chris.vueblog.model.MUser;

public interface UserService {
    MUser selectByPrimaryKey(Long id);
}
