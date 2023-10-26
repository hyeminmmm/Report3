package com.example.report3.common.enums;

import lombok.Getter;

@Getter
public enum NaverApiResponseEnum {
    FAIL_REQUEST_PARAM("요청 변수 오류"),
    FAIL_AUTHORITY("인증 실패"),
    PROHIBIT_CALL("호출 금지/서버가 허용하지 않은 호출"),
    NOT_FOUND_API("API 없음"),
    NOT_ARROW_METHOD("메서드 허용 안함"),
    TOO_MANY_QUARTER("호출 한도 초과"),
    FAIL_SERVER_SYSTEM("서버 오류"),
    FAIL_UNKNOWN("알 수 없는 오류");

    final String description;

    NaverApiResponseEnum(String description) {
        this.description = description;
    }

    public static NaverApiResponseEnum getExceptionResult(String status) {
        return switch (status) {
            case "400" -> FAIL_REQUEST_PARAM;
            case "401" -> FAIL_AUTHORITY;
            case "403" -> PROHIBIT_CALL;
            case "404" -> NOT_FOUND_API;
            case "405" -> NOT_ARROW_METHOD;
            case "429" -> TOO_MANY_QUARTER;
            case "500" -> FAIL_SERVER_SYSTEM;
            default -> FAIL_UNKNOWN;
        };
    }

}
