package com.example.report3.serviceapi.search.application.port.out;

import com.example.report3.serviceapi.search.adapter.out.persistence.entity.SearchCountEntity;

import java.util.List;
import java.util.Optional;

public interface SearchCountPort {
    List<SearchCountEntity> getSearchCountTop10();
    void saveSearchCount(SearchCountEntity searchCountEntity);
    Optional<SearchCountEntity> getSearchCountForUpdate(String keyword);
}
