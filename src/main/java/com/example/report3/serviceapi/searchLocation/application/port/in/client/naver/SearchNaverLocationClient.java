package com.example.report3.serviceapi.searchLocation.application.port.in.client.naver;

import com.example.report3.serviceapi.searchLocation.application.port.in.client.configuration.SearchNaverLocationConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "naverLocationClient", url="${external-api.naver.location}", configuration = SearchNaverLocationConfiguration.class)
public interface SearchNaverLocationClient {
    @GetMapping("/v1/search/local.json")
    String getNaverLocation(@RequestHeader(name = "X-Naver-Client-Id") String clientId,
                                                                                        @RequestHeader(name = "X-Naver-Client-Secret") String clientSecret,
                                                                                        @RequestParam String query,
                                                                                        @RequestParam Integer display);
}
