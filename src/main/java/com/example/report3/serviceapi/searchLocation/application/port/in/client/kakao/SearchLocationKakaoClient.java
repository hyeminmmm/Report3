package com.example.report3.serviceapi.searchLocation.application.port.in.client.kakao;

import com.example.report3.serviceapi.searchLocation.application.port.in.client.configuration.SearchLocationConfiguration;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.dto.KakaoLocationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "kakaoLocationClient", url = "${external-api.kakao.location}", configuration = SearchLocationConfiguration.class)
public interface SearchLocationKakaoClient {
    @GetMapping(value = "/v2/local/search/keyword.json", headers = "application/json;charset=UTF-8")
    KakaoLocationDto.SearchKakaoLocationResponse getKakaoLocation(@RequestHeader String authorization,
                                                                  @RequestParam String query,
                                                                  @RequestParam Integer size);
}
