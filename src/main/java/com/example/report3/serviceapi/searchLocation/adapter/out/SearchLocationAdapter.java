package com.example.report3.serviceapi.searchLocation.adapter.out;

import com.example.report3.serviceapi.searchLocation.application.port.in.client.dto.KakaoLocationDto;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.kakao.SearchLocationKakaoClient;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.naver.SearchLocationNaverClient;
import com.example.report3.serviceapi.searchLocation.application.port.out.SearchLocationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SearchLocationAdapter implements SearchLocationPort {
    private final SearchLocationKakaoClient searchLocationKakaoClient;
    private final SearchLocationNaverClient searchLocationNaverClient;

    @Value("${external-api.kakao.api-key}")
    String apiKey;

    @Value("${external-api.naver.client-id}")
    String clientId;

    @Value("${external-api.naver.client-secret}")
    String clientSecret;

    @Override
    public KakaoLocationDto.SearchKakaoLocationResponse getSearchLocationForKakao(String keyword) {
        return searchLocationKakaoClient.getKakaoLocation("KakaoAK " + apiKey, keyword, 5);
    }

    @Override
    public String getSearchLocationForNaver(String keyword) {
        return searchLocationNaverClient.getNaverLocation(clientId, clientSecret, keyword, 5);
    }
}
