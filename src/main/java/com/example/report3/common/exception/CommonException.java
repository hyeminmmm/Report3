package com.example.report3.common.exception;

import com.example.report3.common.resultcode.ApiResultCodeEnumCode;
import lombok.Getter;

@Getter
public class CommonException extends RuntimeException{
    private final String message;
    private final ApiResultCodeEnumCode apiResultCodeEnumCode;
    private final String developMessage;

    public CommonException(String message, ApiResultCodeEnumCode apiResultCodeEnumCode, String developMessage) {
        this.message = message;
        this.apiResultCodeEnumCode  = apiResultCodeEnumCode;
        this.developMessage = developMessage;
    }
}
