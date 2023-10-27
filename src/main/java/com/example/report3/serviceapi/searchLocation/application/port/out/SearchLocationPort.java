package com.example.report3.serviceapi.searchLocation.application.port.out;

import com.example.report3.serviceapi.searchLocation.application.port.in.client.dto.SearchKakaoLocationResponse;

public interface SearchLocationPort {
    SearchKakaoLocationResponse getSearchLocationForKakao(String keyword);
    String getSearchLocationForNaver(String keyword);
}
