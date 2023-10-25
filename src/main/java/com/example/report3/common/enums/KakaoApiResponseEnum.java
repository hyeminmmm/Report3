package com.example.report3.common.enums;

import lombok.Getter;

@Getter
public enum KakaoApiResponseEnum {
    FAIL_REQUEST("처리 오류"),
    FAIL_TOKEN_AUTHORITY("토큰 인증 오류"),
    FAIL_AUTHORITY("권한 오류"),
    TOO_MANY_QUARTER("쿼터 초과"),
    FAIL_SERVER_SYSTEM("내부 시스템 오류"),
    FAIL_GATEWAY("게이트웨이 오류"),
    SERVICE_UNAVAILABLE("시스템 점검 중"),
    FAIL_UNKNOWN("알 수 없는 오류");

    String description;
    KakaoApiResponseEnum(String description) {
        this.description = description;
    }

    public static KakaoApiResponseEnum getExceptionResult(String status) {
        return switch (status) {
            case "400" -> FAIL_REQUEST;
            case "401" -> FAIL_TOKEN_AUTHORITY;
            case "403" -> FAIL_AUTHORITY;
            case "429" -> TOO_MANY_QUARTER;
            case "500" -> FAIL_SERVER_SYSTEM;
            case "502" -> FAIL_GATEWAY;
            case "503" -> SERVICE_UNAVAILABLE;
            default -> FAIL_UNKNOWN;
        };
    }

}
