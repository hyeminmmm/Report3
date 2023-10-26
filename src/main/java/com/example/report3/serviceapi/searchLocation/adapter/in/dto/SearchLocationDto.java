package com.example.report3.serviceapi.searchLocation.adapter.in.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class SearchLocationDto {
    public record SearchLocationResponse(
        List<String> locations
    ) {}
}
