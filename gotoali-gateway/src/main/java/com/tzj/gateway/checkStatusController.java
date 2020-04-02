package com.tzj.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TianZiJiang
 * @date 2020-03-31
 */
@RestController
public class checkStatusController {

    @GetMapping("status")
    public String checkStatus() {

        return "ok";
    }
}
