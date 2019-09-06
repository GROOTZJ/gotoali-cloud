package com.tzj.controller.feign;

import com.tzj.controller.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("test")
@FeignClient(value = "gotoali-redis")
public interface FeignService {

    /**
     * redis存测试
     *
     * @param name
     * @param value
     * @return
     */
    @GetMapping("redis/set")
    ResultVo testRedisSet(@RequestParam("name") String name,
                                 @RequestParam("value") String value);
}
