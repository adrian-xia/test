package org.adrian.mybatistest.dao;

import org.adrian.mybatistest.domain.UserDO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by xialei on 2017/3/2.
 */
public interface UserMapper {

    Long createOne(UserDO user);

    UserDO selectOne(@Param("id") Long id);

}
