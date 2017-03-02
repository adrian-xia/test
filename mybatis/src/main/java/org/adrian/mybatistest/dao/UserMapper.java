package org.adrian.mybatistest.dao;

import org.adrian.mybatistest.domain.UserDO;

/**
 * Created by xialei on 2017/3/2.
 */
public interface UserMapper {

    Long createOne(UserDO user);

}
