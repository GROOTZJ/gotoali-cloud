package com.tzj.controller.feign;

import com.tzj.controller.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("service")
@FeignClient(value = "gotoali-service")
public interface FeignServiceService {

    /**
     * redis存测试
     *
     * @param userId
     * @return
     */
    @GetMapping("user")
    ResultVo findUserById(@RequestParam("userId") Integer userId);
}
