package com.tzj.service.controller;

import com.tzj.service.service.UserService;
import com.tzj.service.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TianZiJiang
 * @date 2020-03-26
 */
@RestController
@RequestMapping("service")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user")
    public ResultVo findUserById(@RequestParam("userId") Integer userId) {
        if (userId == null) {
            return ResultVo.ofError("userId不能为空");
        }

        return ResultVo.ofSuccess("查询成功！", userService.findUserById(userId).getData());
    }
}
