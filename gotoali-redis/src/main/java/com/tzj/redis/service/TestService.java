package com.tzj.redis.service;

import com.tzj.redis.vo.ResultVo;

/**
 * @author TianZiJiang
 * @date 2019-08-25
 */
public interface TestService {
    ResultVo testRedisSet(String name, String value);

    ResultVo testRedisGet(String name);
}
