package com.example.report3.common.exception;

import com.example.report3.common.resultcode.CommonApiResultCode;
import lombok.Getter;

@Getter
public class CommonException extends RuntimeException{
    private final String message;
    private final CommonApiResultCode commonApiResultCode;

    public CommonException(String message, CommonApiResultCode commonApiResultCode) {
        this.message = message;
        this.commonApiResultCode  = commonApiResultCode;
    }
}
