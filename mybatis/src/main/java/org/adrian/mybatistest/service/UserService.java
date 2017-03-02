package org.adrian.mybatistest.service;

import org.adrian.mybatistest.domain.UserDO;

/**
 * Created by xialei on 2017/3/2.
 */
public interface UserService {
    Long createOne(UserDO user);
}
