package com.tzj.redis.service.impl;

import com.tzj.redis.exception.TestException;
import com.tzj.redis.service.TestService;
import com.tzj.redis.util.RedisUtils;
import com.tzj.redis.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author TianZiJiang
 * @date 2019-08-25
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public ResultVo testRedisSet(String name, String value) {


        redisUtils.setString(name, value);


        return ResultVo.ofSuccess("设置成功！");
    }

    @Override
    public ResultVo testRedisGet(String name) {
        String s = redisUtils.getString(name);
        if (null == s) {
            throw new TestException("出错了！");
        }
        return ResultVo.ofSuccess("获取成功！", s);
    }
}
