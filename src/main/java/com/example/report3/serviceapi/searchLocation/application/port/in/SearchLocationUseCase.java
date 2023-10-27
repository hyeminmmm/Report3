package com.example.report3.serviceapi.searchLocation.application.port.in;

import com.example.report3.common.exception.FailExternalApiRequestException;
import com.example.report3.common.exception.NoParsingException;
import com.example.report3.serviceapi.searchLocation.adapter.in.dto.SearchLocationResponse;

public interface SearchLocationUseCase {
    SearchLocationResponse getSearchLocation(String keyword) throws NoParsingException, FailExternalApiRequestException;
}
