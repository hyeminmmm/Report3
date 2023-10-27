package com.example.report3.serviceapi.searchLocation.application.port.in;

import com.example.report3.common.exception.FailExternalApiRequestException;
import com.example.report3.common.exception.NoParsingException;
import com.example.report3.serviceapi.searchLocation.application.port.in.client.dto.LocationsDto;

public interface SearchLocation {
    LocationsDto getSearchLocation(String keyword) throws NoParsingException, FailExternalApiRequestException;
}
