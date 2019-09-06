package com.tzj.redis.aop;

import com.tzj.redis.exception.TestException;
import com.tzj.redis.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Arrays;

/**
 * aop拦截异常与入参出参记录
 *
 * @author TianZiJiang
 * @date 2019-08-25
 */
@Slf4j
@Aspect
@RestControllerAdvice
public class Advice {

    /**
     * 记录日志-入参出参
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.tzj.eureka.eurekaclient.controller.*Controller.*(..))")
    public Object aroundController(final ProceedingJoinPoint joinPoint) throws Throwable {

        String simpleName = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        long start = System.currentTimeMillis();

        log.info("{}.{}, call with args :{}", simpleName, methodName, args);
        Object proceed = joinPoint.proceed();
        log.info("{}.{}, cost time :{}", simpleName, methodName, System.currentTimeMillis() - start);

        return proceed;
    }

    /**
     * 异常捕获和记录
     *
     * @param httpServletRequest
     * @param throwable
     * @return
     */
    @ExceptionHandler(value = Throwable.class)
    public Object handleException(HttpServletRequest httpServletRequest, Throwable throwable) {

        log.error("Access -- {} -- has Exception", httpServletRequest.getRequestURI(), throwable);

        if (throwable instanceof IllegalArgumentException) {
            return ResultVo.ofError("非法参数");
        } else if (throwable instanceof NullPointerException) {
            return ResultVo.ofError("空指针异常");
        } else if (throwable instanceof TestException) {
            return ResultVo.ofError(((TestException) throwable).getMsg());
        } else if (throwable instanceof  InterruptedException) {
            return ResultVo.ofError("线程终止异常");
        } else if (throwable instanceof DataAccessException) {
            return ResultVo.ofError("数据库异常");
        } else if (throwable instanceof RuntimeException) {
            return ResultVo.ofError("自定义异常");
        } else if (throwable instanceof ParseException) {
            return ResultVo.ofError("日期转换格式异常");
        } else {
            return ResultVo.ofError("未知异常");
        }
    }


}
