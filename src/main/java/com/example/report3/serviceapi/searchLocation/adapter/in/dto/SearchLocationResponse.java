package com.example.report3.serviceapi.searchLocation.adapter.in.dto;

import java.util.Set;

public record SearchLocationResponse (
    Set<String> locations
) {}