package com.example.report3.serviceapi.search.application.port.out;

import com.example.report3.serviceapi.search.adapter.out.persistence.entity.SearchCountEntity;
import com.example.report3.serviceapi.search.adapter.out.persistence.entity.SearchCountViewEntity;

import java.util.List;
import java.util.Optional;

public interface SearchCountPort {
    List<SearchCountViewEntity> getSearchCountTop10();
    void saveSearchCount(SearchCountEntity searchCountEntity);
    void saveSearchViewCount(SearchCountViewEntity searchCountViewEntity);
    Optional<SearchCountEntity> getSearchCountForUpdate(String keyword);
    Optional<SearchCountViewEntity> getSearchCountView(String keyword);
}
