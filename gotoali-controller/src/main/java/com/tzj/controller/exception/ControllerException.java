package com.tzj.controller.exception;

/**
 * 自定义异常
 *
 * @author TianZiJiang
 * @date 2019-08-25
 */
public class ControllerException extends RuntimeException {
    private String msg;

    public ControllerException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
