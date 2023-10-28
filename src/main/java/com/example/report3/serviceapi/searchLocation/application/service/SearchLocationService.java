package com.example.report3.serviceapi.searchLocation.application.service;

import com.example.report3.common.exception.FailExternalApiRequestException;
import com.example.report3.common.exception.NoParsingException;
import com.example.report3.serviceapi.searchLocation.adapter.in.dto.SearchLocationResponse;
import com.example.report3.serviceapi.searchLocation.application.port.in.SearchLocation;
import com.example.report3.serviceapi.searchLocation.application.port.in.SearchLocationUseCase;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.dto.LocationsDto;
import com.example.report3.serviceapi.searchLocation.application.port.out.SearchLocationPort;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SearchLocationService implements SearchLocationUseCase {
    private final SearchLocationPort searchLocationPort;

    public SearchLocationResponse getSearchLocation(String keyword) throws NoParsingException, FailExternalApiRequestException {
        SearchLocation searchLocationKakao = new SearchLocationKakao(searchLocationPort);
        LocationsDto kakaoLocations = searchLocationKakao.getSearchLocation(keyword);

        SearchLocation searchLocationNaver = new SearchLocationNaver(searchLocationPort, new ObjectMapper());
        LocationsDto naverLocations = searchLocationNaver.getSearchLocation(keyword);

        searchLocationPort.saveSearchCount(keyword);

        return new SearchLocationResponse(getLocationResult(kakaoLocations, naverLocations));
    }

    private Set<String> getLocationResult(LocationsDto kakaoLocations, LocationsDto naverLocations) {
        Set<String> result = new LinkedHashSet<>();

        for (int i = 0; i < kakaoLocations.mapxyList().size(); i++) {
            if(naverLocations.mapxySet().contains(kakaoLocations.mapxyList().get(i))) {
                result.add(kakaoLocations.places().get(i));
            }
        }

        for (int i = 0; i < kakaoLocations.places().size(); i++) {
            if (result.size() >= 10) return result;
            if (!result.contains(kakaoLocations.places().get(i))) {
                result.add(kakaoLocations.places().get(i));
            }
        }

        for (int i = 0; i < naverLocations.placeNameSet().size(); i++) {
            if (result.size() >= 10) return result;
            if (!result.contains(naverLocations.places().get(i))) {
                result.add(naverLocations.places().get(i));
            }
        }
        return result;
    }
}
