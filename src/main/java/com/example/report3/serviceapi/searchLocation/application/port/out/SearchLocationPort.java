package com.example.report3.serviceapi.searchLocation.application.port.out;

import com.example.report3.serviceapi.searchLocation.application.port.in.client.dto.KakaoLocationDto;

public interface SearchLocationPort {
    KakaoLocationDto.SearchKakaoLocationResponse getSearchLocationForKakao(String keyword);
    String getSearchLocationForNaver(String keyword);
}
