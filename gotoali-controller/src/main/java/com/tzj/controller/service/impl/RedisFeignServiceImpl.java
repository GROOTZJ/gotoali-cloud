package com.tzj.controller.service.impl;

import com.tzj.controller.feign.FeignService;
import com.tzj.controller.service.RedisFeignService;
import com.tzj.controller.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author TianZiJiang
 * @date 2019-08-30
 */
@Service
public class RedisFeignServiceImpl implements RedisFeignService {

    @Autowired
    private FeignService feignService;

    @Override
    public ResultVo setRedis(String name, String value) {
        ResultVo resultVo = feignService.testRedisSet(name, value);
        return resultVo;
    }
}
