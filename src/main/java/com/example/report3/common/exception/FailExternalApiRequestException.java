package com.example.report3.common.exception;

import lombok.Getter;

@Getter
public class FailExternalApiRequestException extends Throwable{
    String message;

    public FailExternalApiRequestException(String message) {
        this.message = message;
    }
}
