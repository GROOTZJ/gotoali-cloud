package com.tzj.service.service;


import com.tzj.service.vo.ResultVo;

public interface UserService {

    /**
     * 根据userId查询user
     *
     * @param userId
     * @return
     */
    ResultVo findUserById(Integer userId);
}
