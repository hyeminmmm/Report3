package com.example.report3.serviceapi.search.adapter.in.dto;

import java.util.List;

public record SearchCountResponse(
        List<SearchCountHistory> searchCountHistoryList
) {
    public record SearchCountHistory(
            String keyword,
            Integer count
    ) {
    }
}