package com.example.report3.serviceapi.searchLocation.application.port.in.client.kakao;

import com.example.report3.serviceapi.searchLocation.application.port.in.client.configuration.SearchKakaoLocationConfiguration;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.dto.KakaoLocationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "kakaoLocationClient", url = "${external-api.kakao.location}", configuration = SearchKakaoLocationConfiguration.class)
public interface SearchKakaoLocationClient {

    @GetMapping(value = "/v2/local/search/keyword.json")
    KakaoLocationDto.SearchKakaoLocationResponse getKakaoLocation(@RequestHeader String authorization,
                                                                  @RequestParam String query,
                                                                  @RequestParam Integer size);
}
