package com.example.report3.serviceapi.searchLocation.application.port.in.client.dto;

import java.util.List;
import java.util.Set;

public record LocationsDto (
        Set<String> mapxySet,
        List<String> mapxyList,
        List<String> places,
        Set<String> placeNameSet
) {}
