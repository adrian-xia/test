package org.adrian.mybatistest.controller;

import org.adrian.mybatistest.domain.ResultDO;
import org.adrian.mybatistest.domain.UserDO;
import org.adrian.mybatistest.service.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xialei on 2017/3/2.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "createOne", method = RequestMethod.POST)
    public ResultDO createOne(@RequestBody UserDO user) {
        DateTime createTime = DateTime.now();
        user.setCreateTime(createTime);
        user.setUpdateTime(createTime);
        user.setCreateBy(0L);
        user.setUpdateBy(0L);
        Long data = userService.createOne(user);
        ResultDO resultDO = new ResultDO();
        resultDO.setResultCode(0);
        resultDO.setResultMsg("success");
        resultDO.setData(data);
        return resultDO;
    }

}
