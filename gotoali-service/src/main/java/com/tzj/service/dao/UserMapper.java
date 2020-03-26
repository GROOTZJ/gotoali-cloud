package com.tzj.service.dao;


import com.tzj.service.dao.po.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    UserDO findUserById(@Param("id") Integer userId);
}
