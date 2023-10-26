package com.example.report3.serviceapi.searchLocation.application.port.in;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface SearchLocation {
    List<String> getSearchLocation(String keyword) throws JsonProcessingException;
}
