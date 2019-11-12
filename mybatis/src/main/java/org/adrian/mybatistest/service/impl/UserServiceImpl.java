package org.adrian.mybatistest.service.impl;

import org.adrian.mybatistest.dao.UserMapper;
import org.adrian.mybatistest.domain.UserDO;
import org.adrian.mybatistest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xialei on 2017/3/2.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Long createOne(UserDO user) {
        return userMapper.createOne(user);
    }
}
