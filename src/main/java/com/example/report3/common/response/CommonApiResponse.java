package com.example.report3.common.response;

import com.example.report3.common.resultcode.CommonApiResultCode;

public class CommonApiResponse<T> {
    private T contents;
    private CommonApiResultCode commonApiResultCode;

    public CommonApiResponse(T contents, CommonApiResultCode commonApiResultCode) {
        this.contents = contents;
        this.commonApiResultCode = commonApiResultCode;
    }
}
