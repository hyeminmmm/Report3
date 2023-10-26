package com.example.report3.serviceapi.searchLocation.application.service;

import com.example.report3.common.enums.KakaoApiResponseEnum;
import com.example.report3.common.exception.CommonException;
import com.example.report3.common.resultcode.ApiResultCodeEnumCode;
import com.example.report3.serviceapi.searchLocation.application.port.in.SearchLocation;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.dto.KakaoLocationDto;
import com.example.report3.serviceapi.searchLocation.application.port.out.SearchLocationPort;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchLocationKakao implements SearchLocation {
    private final SearchLocationPort searchLocationPort;

    @Override
    public List<String> getSearchLocation(String keyword) {
        List<String> result = new ArrayList<>();
        KakaoLocationDto.SearchKakaoLocationResponse searchKakaoLocationResponse;
        try {
            searchKakaoLocationResponse = searchLocationPort.getSearchLocationForKakao(keyword);
        } catch (FeignException e) {
            KakaoApiResponseEnum exceptionResult = KakaoApiResponseEnum.getExceptionResult(String.valueOf(e.status()));
            throw new CommonException(exceptionResult.getDescription(), ApiResultCodeEnumCode.COMMON_SUCCESS_WITHOUT_MESSAGE, e.getMessage());
        }
        searchKakaoLocationResponse.documents().forEach(documents -> result.add(documents.placeName()));
        return result;
    }
}
