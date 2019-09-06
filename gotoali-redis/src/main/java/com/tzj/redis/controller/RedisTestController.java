package com.tzj.redis.controller;

import com.tzj.redis.service.TestService;
import com.tzj.redis.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TianZiJiang
 * @date 2019-08-25
 */
@RestController
@RequestMapping("test")
public class RedisTestController {

    @Autowired
    private TestService testService;

    @ApiOperation(value="redis存测试")
    @GetMapping("redis/set")
    public ResultVo testRedisSet(@RequestParam("name") String name,
                                 @RequestParam("value") String value) {
        return testService.testRedisSet(name, value);
    }

    @ApiOperation(value="redis取测试")
    @GetMapping("redis/get")
    public ResultVo testRedisGet(@RequestParam("name") String name) {
        return testService.testRedisGet(name);
    }

}
