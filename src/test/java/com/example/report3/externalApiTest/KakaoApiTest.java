package com.example.report3.externalApiTest;

import com.example.report3.common.enums.KakaoApiResponseEnum;
import com.example.report3.common.exception.CommonException;
import com.example.report3.common.resultcode.CommonApiResultCode;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.dto.KakaoLocationDto;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.dto.NaverLocationDto;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.kakao.SearchKakaoLocationClient;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.naver.SearchNaverLocationClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootTest
@Slf4j
public class KakaoApiTest {

    @Autowired
    SearchKakaoLocationClient searchKakaoLocationClient;

    @Autowired
    SearchNaverLocationClient searchNaverLocationClient;

    @Value("${external-api.kakao.api-key}")
    String apiKey;

    @Value("${external-api.naver.client-id}")
    String clientId;

    @Value("${external-api.naver.client-secret}")
    String clientSecret;

    @Test
    public void 카카오검색api() {
        String authorization = "KakaoAK " + apiKey;
        KakaoLocationDto.SearchKakaoLocationResponse search;
        String keyword = "곱창";
        try {
            search = searchKakaoLocationClient.getKakaoLocation(authorization,keyword, 5);
        } catch (FeignException e) {
            KakaoApiResponseEnum exceptionResult = KakaoApiResponseEnum.getExceptionResult(String.valueOf(e.status()));
            throw new CommonException(exceptionResult.getDescription(), CommonApiResultCode.COMMON_SUCCESS_WITHOUT_MESSAGE);
        }

        Assertions.assertEquals(keyword, search.meta().sameName().keyword());
    }

    @Test
    public void 네이버검색api() throws JsonProcessingException {
        String keyword = "곱창";
        String naverLocation = "";
        try {
            naverLocation = searchNaverLocationClient.getNaverLocation(clientId+"dfd", clientSecret, keyword, 5);
        } catch (FeignException e) {
            log.info("dfsfd");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        NaverLocationDto.SearchNaverLocationResponse searchNaverLocationResponse = objectMapper.readValue(naverLocation, NaverLocationDto.SearchNaverLocationResponse.class);
        Assertions.assertEquals(5, searchNaverLocationResponse.display());
    }

    @Test
    public void 검색알고리즘() {
        List<String> kakaoLocations = new ArrayList<>();
        List<String> naverLocations = new LinkedList<>();
        List<String> result = new ArrayList<>();

        kakaoLocations.add("카카오뱅크");
        kakaoLocations.add("우리은행");
        kakaoLocations.add("국민은행");
        kakaoLocations.add("부산은행");
        kakaoLocations.add("새마을금고");

        naverLocations.add("카카오뱅크");
        naverLocations.add("부산은행");
        naverLocations.add("하나은행");
        naverLocations.add("국민은행");
        naverLocations.add("기업은행");

        int num = 0;

        for (String kakaoLocation: kakaoLocations) {
            if(naverLocations.contains(kakaoLocation)) {
                result.add(kakaoLocation);
                naverLocations.remove(kakaoLocation);
            } else {
                naverLocations.add(num, kakaoLocation);
                num++;
            }
        }
        naverLocations.forEach(naverLocation -> {
            if(result.size() >= 10) return;

            result.add(naverLocation);
        });

        log.info(result.toString());
    }
}
