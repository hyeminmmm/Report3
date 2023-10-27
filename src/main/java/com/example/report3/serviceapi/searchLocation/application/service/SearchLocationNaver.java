package com.example.report3.serviceapi.searchLocation.application.service;

import com.example.report3.common.enums.NaverApiResponseEnum;
import com.example.report3.common.exception.FailExternalApiRequestException;
import com.example.report3.common.exception.NoParsingException;
import com.example.report3.serviceapi.searchLocation.application.port.in.SearchLocation;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.dto.LocationsDto;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.dto.SearchNaverLocationResponse;
import com.example.report3.serviceapi.searchLocation.application.port.out.SearchLocationPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class SearchLocationNaver implements SearchLocation {
    private final SearchLocationPort searchLocationPort;
    private final ObjectMapper objectMapper;

    @Override
    public LocationsDto getSearchLocation(String keyword) throws NoParsingException, FailExternalApiRequestException {
        String naverLocationString = "";
        Set<String> mapxySet = new LinkedHashSet<>();
        List<String> mapxyList = new ArrayList<>();
        List<String> places = new ArrayList<>();
        Set<String> placeNameSet = new LinkedHashSet<>();

        try {
            naverLocationString = searchLocationPort.getSearchLocationForNaver(keyword);
        } catch (FeignException e) {
            NaverApiResponseEnum exceptionResult = NaverApiResponseEnum.getExceptionResult(String.valueOf(e.status()));
            throw new FailExternalApiRequestException(exceptionResult.getDescription());
        }

        SearchNaverLocationResponse searchNaverLocationResponse;
        try {
            searchNaverLocationResponse = objectMapper.readValue(naverLocationString, SearchNaverLocationResponse.class);
        } catch (JsonProcessingException e) {
            throw new NoParsingException();
        }

        for(int i = 0; i < searchNaverLocationResponse.items().size(); i++) {
            String place = searchNaverLocationResponse.items().get(i).title();
            String mapx = searchNaverLocationResponse.items().get(i).mapx().replace("\\.", "").substring(0,9);
            String mapy = searchNaverLocationResponse.items().get(i).mapy().replace("\\.", "").substring(0,9);
            mapxySet.add(mapx + "," + mapy);
            mapxyList.add(mapx + "," + mapy);
            places.add(searchNaverLocationResponse.items().get(i).title());
            placeNameSet.add(place);
        }

        return new LocationsDto(mapxySet, mapxyList, places, placeNameSet);
    }
}
