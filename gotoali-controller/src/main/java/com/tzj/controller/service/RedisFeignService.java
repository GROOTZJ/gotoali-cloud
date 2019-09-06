package com.tzj.controller.service;

import com.tzj.controller.vo.ResultVo;

public interface RedisFeignService {
    ResultVo setRedis(String name, String value);
}
