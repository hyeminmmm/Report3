package com.example.report3.serviceapi.searchLocation.application.port.in;

import com.example.report3.serviceapi.searchLocation.adapter.in.dto.SearchLocationDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface SearchLocationUseCase {
    SearchLocationDto.SearchLocationResponse getSearchLocation(String keyword) throws JsonProcessingException;
}
