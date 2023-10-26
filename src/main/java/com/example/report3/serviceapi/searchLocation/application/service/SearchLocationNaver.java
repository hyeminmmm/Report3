package com.example.report3.serviceapi.searchLocation.application.service;

import com.example.report3.common.enums.NaverApiResponseEnum;
import com.example.report3.common.exception.CommonException;
import com.example.report3.common.resultcode.ApiResultCodeEnumCode;
import com.example.report3.serviceapi.searchLocation.application.port.in.SearchLocation;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.dto.NaverLocationDto;
import com.example.report3.serviceapi.searchLocation.application.port.out.SearchLocationPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchLocationNaver implements SearchLocation {
    private final SearchLocationPort searchLocationPort;

    @Override
    public List<String> getSearchLocation(String keyword) throws JsonProcessingException {
        String naverLocationString = "";
        List<String> result = new LinkedList<>();

        try {
            naverLocationString = searchLocationPort.getSearchLocationForNaver(keyword);
        } catch (FeignException e) {
            NaverApiResponseEnum exceptionResult = NaverApiResponseEnum.getExceptionResult(String.valueOf(e.status()));
            throw new CommonException(exceptionResult.getDescription(), ApiResultCodeEnumCode.COMMON_FAIL_WITHOUT_MESSAGE, e.getMessage());
        }

        ObjectMapper objectMapper = new ObjectMapper();
        NaverLocationDto.SearchNaverLocationResponse searchNaverLocationResponse = objectMapper.readValue(naverLocationString, NaverLocationDto.SearchNaverLocationResponse.class);
        searchNaverLocationResponse.items().forEach(item -> result.add(item.title()));
        return result;
    }
}
