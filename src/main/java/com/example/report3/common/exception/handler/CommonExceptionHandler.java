package com.example.report3.common.exception.handler;

import com.example.report3.common.exception.FailExternalApiRequestException;
import com.example.report3.common.exception.NoParsingException;
import com.example.report3.common.response.CommonApiResponse;
import com.example.report3.common.resultcode.ApiResultCodeEnumCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {
    @ExceptionHandler(NoParsingException.class)
    protected ResponseEntity<CommonApiResponse<?>> noParsingException(NoParsingException e) {
        return new ResponseEntity<>(new CommonApiResponse<>(null, ApiResultCodeEnumCode.NO_PARSING), HttpStatus.OK);
    }

    @ExceptionHandler(FailExternalApiRequestException.class)
    protected ResponseEntity<CommonApiResponse<?>> failExternalApiRequestException(FailExternalApiRequestException e) {
        return new ResponseEntity<>(new CommonApiResponse<>(e.getMessage(), ApiResultCodeEnumCode.COMMON_FAIL_REQUEST_EXTERNAL_API), HttpStatus.OK);
    }
}
