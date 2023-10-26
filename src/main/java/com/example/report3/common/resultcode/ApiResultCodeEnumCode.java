package com.example.report3.common.resultcode;

import com.example.report3.common.enums.ApiResultCodeType;

public enum ApiResultCodeEnumCode{
    COMMON_SUCCESS_WITHOUT_MESSAGE(ApiResultCodeType.SN, "SN_COMMON_001", null, null),
    COMMON_FAIL_WITHOUT_MESSAGE(ApiResultCodeType.FN, "FN_COMMON_001", null, null);

    private ApiResultCodeType apiResultCodeType; // 결과 타입
    private String resultCode; // 결과 코드
    private String resultMessage; // 결과 메시지
    private String developMessage; // 개발자 확인 메시지


    public ApiResultCodeType getApiResultCodeType() {
        return apiResultCodeType;
    }
    public String getResultCode() {
        return resultCode;
    }
    public String getResultMessage() {
        return resultMessage;
    }
    public String getDevelopMessage() {
        return developMessage;
    }

    ApiResultCodeEnumCode(ApiResultCodeType apiResultCodeType, String resultCode, String resultMessage, String developMessage) {
        this.apiResultCodeType = apiResultCodeType;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.developMessage = developMessage;
    }
}
