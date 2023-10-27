package com.example.report3.serviceapi.searchLocation.application.service;

import com.example.report3.common.enums.KakaoApiResponseEnum;
import com.example.report3.common.exception.FailExternalApiRequestException;
import com.example.report3.serviceapi.searchLocation.application.port.in.SearchLocation;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.dto.LocationsDto;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.dto.SearchKakaoLocationResponse;
import com.example.report3.serviceapi.searchLocation.application.port.out.SearchLocationPort;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class SearchLocationKakao implements SearchLocation {
    private final SearchLocationPort searchLocationPort;

    @Override
    public LocationsDto getSearchLocation(String keyword) throws FailExternalApiRequestException {
        Set<String> mapxySet = new LinkedHashSet<>();
        List<String> mapxyList = new ArrayList<>();
        List<String> places = new ArrayList<>();
        Set<String> placeNameSet = new LinkedHashSet<>();

        SearchKakaoLocationResponse searchKakaoLocationResponse;
        try {
            searchKakaoLocationResponse = searchLocationPort.getSearchLocationForKakao(keyword);
        } catch (FeignException e) {
            KakaoApiResponseEnum exceptionResult = KakaoApiResponseEnum.getExceptionResult(String.valueOf(e.status()));
            throw new FailExternalApiRequestException(exceptionResult.getDescription());
        }

        for (int i = 0; i < searchKakaoLocationResponse.documents().size(); i++) {
            String place = searchKakaoLocationResponse.documents().get(i).placeName();
            String mapx = searchKakaoLocationResponse.documents().get(i).x().replaceAll("\\.", "").substring(0, 9);
            String mapy = searchKakaoLocationResponse.documents().get(i).y().replaceAll("\\.", "").substring(0, 9);
            mapxySet.add(mapx + "," + mapy);
            mapxyList.add(mapx + "," + mapy);
            places.add(searchKakaoLocationResponse.documents().get(i).placeName());
            placeNameSet.add(place);
        }

        return new LocationsDto(mapxySet, mapxyList, places, placeNameSet);
    }
}
