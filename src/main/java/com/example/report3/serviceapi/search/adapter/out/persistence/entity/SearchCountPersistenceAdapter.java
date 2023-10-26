package com.example.report3.serviceapi.search.adapter.out.persistence.entity;

import com.example.report3.serviceapi.search.application.port.out.SearchCountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SearchCountPersistenceAdapter implements SearchCountPort {
    private final SearchCountRepository searchCountRepository;
    @Override
    public List<SearchCountEntity> getSearchCountTop10() {
        return searchCountRepository.findTop10ByOrderByCountDesc();
    }

    @Override
    public void saveSearchCount(SearchCountEntity searchCountEntity) {
        searchCountRepository.save(searchCountEntity);
    }
}
