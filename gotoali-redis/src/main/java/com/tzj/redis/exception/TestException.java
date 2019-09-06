package com.tzj.redis.exception;

/**
 * 自定义异常
 *
 * @author TianZiJiang
 * @date 2019-08-25
 */
public class TestException extends RuntimeException {
    private String msg;

    public TestException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
