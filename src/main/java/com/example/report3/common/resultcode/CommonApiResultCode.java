package com.example.report3.common.resultcode;

import com.example.report3.common.enums.ApiResultCodeType;

public enum CommonApiResultCode{
    COMMON_SUCCESS_WITHOUT_MESSAGE(ApiResultCodeType.SN, "SN_COMMON_001", null),
    COMMON_FAIL_WITHOUT_MESSAGE(ApiResultCodeType.FN, "FN_COMMON_001", null);

    private final ApiResultCodeType apiResultCodeType;
    private final String resultMessage;
    private final String message;

    CommonApiResultCode(ApiResultCodeType apiResultCodeType, String resultMessage, String message) {
        this.apiResultCodeType = apiResultCodeType;
        this.resultMessage = resultMessage;
        this.message = message;
    }
}
