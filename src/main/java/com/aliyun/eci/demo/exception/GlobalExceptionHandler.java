package com.aliyun.eci.demo.exception;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局ControllerAdvice，优先级要设置的最低
 */
@RestControllerAdvice(basePackages = {"com.aliyun.eci.demo"})
@Order
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(Exception e) {
        return "unknown error";
    }
}