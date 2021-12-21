package com.aliyun.eci.demo.exception;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * narrow ControllerAdvice
 * 优先级在全局的前面
 */
@Order(10000)
@RestControllerAdvice(basePackages = {"com.aliyun.eci.demo"})
public class SelectorExceptionHandler {

    @ExceptionHandler(SystemException.class)
    public Object customHandler(SystemException e) {
        return e.getErrorCode() + ":" + e.getErrorMsg();
    }
}
