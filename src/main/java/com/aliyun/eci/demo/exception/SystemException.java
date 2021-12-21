package com.aliyun.eci.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SystemException extends Exception {

    private String errorCode;

    private String errorMsg;

    public SystemException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
