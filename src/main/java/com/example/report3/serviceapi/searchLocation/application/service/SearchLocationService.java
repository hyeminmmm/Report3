package com.example.report3.serviceapi.searchLocation.application.service;

import com.example.report3.serviceapi.searchLocation.adapter.in.dto.SearchLocationDto;
import com.example.report3.serviceapi.searchLocation.application.port.in.SearchLocation;
import com.example.report3.serviceapi.searchLocation.application.port.in.SearchLocationUseCase;
import com.example.report3.serviceapi.searchLocation.application.port.out.SearchLocationPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchLocationService implements SearchLocationUseCase {
    private final SearchLocationPort searchLocationPort;
    public SearchLocationDto.SearchLocationResponse getSearchLocation(String keyword) throws JsonProcessingException {
        SearchLocation searchLocationKakao = new SearchLocationKakao(searchLocationPort);
        List<String> kakaoLocations = searchLocationKakao.getSearchLocation(keyword);

        SearchLocation searchLocationNaver = new SearchLocationNaver(searchLocationPort);
        List<String> naverLocations = searchLocationNaver.getSearchLocation(keyword);

        return new SearchLocationDto.SearchLocationResponse(getLocationResult(kakaoLocations, naverLocations));
    }

    private List<String> getLocationResult(List<String> kakaoLocations, List<String> naverLocations) {
        int num = 0;
        List<String> result = new ArrayList<>();

        for (String kakaoLocation: kakaoLocations) {
            if(naverLocations.contains(kakaoLocation)) {
                result.add(kakaoLocation);
                naverLocations.remove(kakaoLocation);
            } else {
                naverLocations.add(num, kakaoLocation);
                num++;
            }
        }
        naverLocations.forEach(naverLocation -> {
            if(result.size() >= 10) return;

            result.add(naverLocation);
        });

        return result;
    }
}
