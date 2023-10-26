package com.example.report3.serviceapi.searchLocation.adapter.in.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class SearchLocationDto {
    public record SearchLocationResponse(
        List<String> locations
    ) {}
}
