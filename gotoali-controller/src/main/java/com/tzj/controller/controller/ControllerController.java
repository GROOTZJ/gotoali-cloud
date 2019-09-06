package com.tzj.controller.controller;

import com.tzj.controller.service.RedisFeignService;
import com.tzj.controller.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author TianZiJiang
 * @date 2019-08-27
 */
@RestController
@RequestMapping("controller")
public class ControllerController {

    @Autowired
    private RedisFeignService redisFeignService;

    @GetMapping("test")
    @ApiOperation(value="controller测试")
    public ResultVo test() {

        return ResultVo.ofSuccess("ok");
    }

    @PostMapping("redis")
    @ApiOperation(value="redis存测试")
    public ResultVo setRedis(@RequestParam("name") String name,
                             @RequestParam("value") String value) {

        return redisFeignService.setRedis(name, value);
    }

//    TODO fegin调用  service层 dao层  整合mysql

}
