package com.tzj.service.service.impl;

import com.tzj.service.dao.UserMapper;
import com.tzj.service.service.UserService;
import com.tzj.service.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author TianZiJiang
 * @date 2020-03-26
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据userId查询User
     *
     * @param userId
     * @return
     */
    @Override
    public ResultVo findUserById(Integer userId) {
        if (userId == null) {
            return ResultVo.ofError("userId不能为空");
        }
        return ResultVo.ofSuccess("查询成功！", userMapper.findUserById(userId));
    }
}
