package com.example.report3.serviceapi.search.application.port.out;

import com.example.report3.serviceapi.search.adapter.out.persistence.entity.SearchCountEntity;

import java.util.List;

public interface SearchCountPort {
    List<SearchCountEntity> getSearchCountTop10();
    void saveSearchCount(SearchCountEntity searchCountEntity);
}
