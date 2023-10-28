package com.example.report3.serviceapi.search.application.port.in;

import com.example.report3.serviceapi.search.adapter.in.dto.SearchCountResponse;

public interface SearchCountUseCase {
    SearchCountResponse getSearchCountViews();
    void saveSearchCount(String keyword);
}
