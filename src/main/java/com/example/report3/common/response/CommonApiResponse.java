package com.example.report3.common.response;

import com.example.report3.common.enums.ApiResultCodeType;
import com.example.report3.common.resultcode.ApiResultCodeEnumCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class CommonApiResponse<T> {
    private T contents;

    private Result result;

    @Getter
    @AllArgsConstructor
    public static class Result {
        private ApiResultCodeType resultCodeType;
        private String resultCode;
        private String resultMessage;
        private String developMessage;
    }

    public CommonApiResponse(T contents, ApiResultCodeEnumCode apiResultCodeEnumCode) {
        Result result = new Result(apiResultCodeEnumCode.getApiResultCodeType(),
                apiResultCodeEnumCode.getResultCode(),
                apiResultCodeEnumCode.getResultMessage(),
                apiResultCodeEnumCode.getDevelopMessage());

        this.contents = contents;
        this.result = result;
    }
}
