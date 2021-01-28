package com.chris.vueblog.service.impl;


import com.chris.vueblog.mapper.MUserMapper;
import com.chris.vueblog.model.MUser;
import com.chris.vueblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    MUserMapper mUserMapper;
    @Override
    public MUser selectByPrimaryKey(Long id) {
        return mUserMapper.selectByPrimaryKey(id);
    }



}
