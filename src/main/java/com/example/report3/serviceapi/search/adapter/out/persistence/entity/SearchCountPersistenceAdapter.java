package com.example.report3.serviceapi.search.adapter.out.persistence.entity;

import com.example.report3.serviceapi.search.application.port.out.SearchCountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SearchCountPersistenceAdapter implements SearchCountPort {
    private final SearchCountRepository searchCountRepository;
    private final SearchCountViewRepository searchCountViewRepository;
    @Override
    public List<SearchCountViewEntity> getSearchCountTop10() {
        return searchCountViewRepository.findTop10ByOrderByCountDesc();
    }

    @Override
    public void saveSearchCount(SearchCountEntity searchCountEntity) {
        searchCountRepository.save(searchCountEntity);
    }

    @Override
    public void saveSearchViewCount(SearchCountViewEntity searchCountViewEntity) {
        searchCountViewRepository.save(searchCountViewEntity);
    }

    @Override
    public Optional<SearchCountEntity> getSearchCountForUpdate(String keyword) {
        return searchCountRepository.findByKeyword(keyword);
    }

    @Override
    public Optional<SearchCountViewEntity> getSearchCountView(String keyword) {
        return searchCountViewRepository.findByKeyword(keyword);
    }
}
