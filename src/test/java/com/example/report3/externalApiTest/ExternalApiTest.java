package com.example.report3.externalApiTest;

import com.example.report3.common.enums.KakaoApiResponseEnum;
import com.example.report3.common.enums.NaverApiResponseEnum;
import com.example.report3.common.exception.CommonException;
import com.example.report3.common.exception.FailExternalApiRequestException;
import com.example.report3.common.exception.NoParsingException;
import com.example.report3.common.resultcode.ApiResultCodeEnumCode;
import com.example.report3.serviceapi.searchLocation.adapter.in.dto.SearchLocationResponse;
import com.example.report3.serviceapi.searchLocation.application.port.in.SearchLocationUseCase;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.dto.SearchKakaoLocationResponse;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.dto.SearchNaverLocationResponse;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.kakao.SearchLocationKakaoClient;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.naver.SearchLocationNaverClient;
import com.example.report3.serviceapi.searchLocation.application.port.out.SearchLocationPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
@Slf4j
public class ExternalApiTest {

    @Autowired
    SearchLocationKakaoClient searchLocationKakaoClient;

    @Autowired
    SearchLocationNaverClient searchLocationNaverClient;

    @Autowired
    SearchLocationUseCase searchLocationUseCase;

    @Autowired
    SearchLocationPort searchLocationPort;

    @Value("${external-api.kakao.api-key}")
    String apiKey;

    @Value("${external-api.naver.client-id}")
    String clientId;

    @Value("${external-api.naver.client-secret}")
    String clientSecret;

    @Test
    public void 카카오검색api() {
        String authorization = "KakaoAK " + apiKey;
        SearchKakaoLocationResponse search;
        String keyword = "곱창";
        try {
            search = searchLocationKakaoClient.getKakaoLocation(authorization,keyword, 5);
        } catch (FeignException e) {
            KakaoApiResponseEnum exceptionResult = KakaoApiResponseEnum.getExceptionResult(String.valueOf(e.status()));
            throw new CommonException(exceptionResult.getDescription(), ApiResultCodeEnumCode.COMMON_SUCCESS_WITHOUT_MESSAGE, e.getMessage());
        }

        Assertions.assertEquals(keyword, search.meta().sameName().keyword());
    }

    @Test
    public void 네이버검색api() throws JsonProcessingException {
        String keyword = "곱창";
        String naverLocation = "";
        try {
            naverLocation = searchLocationNaverClient.getNaverLocation(clientId, clientSecret, keyword, 5);
        } catch (FeignException e) {
            NaverApiResponseEnum exceptionResult = NaverApiResponseEnum.getExceptionResult(String.valueOf(e.status()));
            throw new CommonException(exceptionResult.getDescription(), ApiResultCodeEnumCode.COMMON_FAIL_WITHOUT_MESSAGE, e.getMessage());
        }

        ObjectMapper objectMapper = new ObjectMapper();
        SearchNaverLocationResponse searchNaverLocationResponse = objectMapper.readValue(naverLocation, SearchNaverLocationResponse.class);
        Assertions.assertEquals(5, searchNaverLocationResponse.display());
    }

    @Test
    public void 통합테스트() throws JsonProcessingException, NoParsingException, FailExternalApiRequestException {
        String keyword = "곱창";
        SearchLocationResponse searchLocation = searchLocationUseCase.getSearchLocation(keyword);

        log.info(searchLocation.locations().toString());
    }

}
