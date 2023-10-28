package com.example.report3.serviceapi.search.application.service;

import com.example.report3.serviceapi.search.adapter.in.dto.SearchCountResponse;
import com.example.report3.serviceapi.search.adapter.out.persistence.entity.SearchCountEntity;
import com.example.report3.serviceapi.search.adapter.out.persistence.entity.SearchCountViewEntity;
import com.example.report3.serviceapi.search.application.port.in.SearchCountUseCase;
import com.example.report3.serviceapi.search.application.port.out.SearchCountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SearchCountService implements SearchCountUseCase {
    private final SearchCountPort searchCountPort;

    @Override
    public SearchCountResponse getSearchCountViews() {
        List<SearchCountResponse.SearchCountHistory> searchCountHistory = new ArrayList<>();
        List<SearchCountViewEntity> searchCountViews = searchCountPort.getSearchCountTop10();

        searchCountViews.forEach(searchCountViewEntity ->
            searchCountHistory.add(new SearchCountResponse.SearchCountHistory(
                    searchCountViewEntity.getKeyword(), Math.toIntExact(searchCountViewEntity.getCount())))
        );

        return new SearchCountResponse(searchCountHistory);
    }
    @Override
    @Transactional
    public void saveSearchCount(String keyword) {
        Optional<SearchCountEntity> searchCount = searchCountPort.getSearchCountForUpdate(keyword);

        if (searchCount.isPresent()) {
            Optional<SearchCountViewEntity> searchCountView = searchCountPort.getSearchCountView(keyword);
            searchCountView.ifPresent(searchCountViewEntity -> searchCountViewEntity.updateCount(searchCount.get().getCount() + 1));
            searchCount.get().updateCount(searchCount.get().getCount() + 1);
        } else {
            searchCountPort.saveSearchCount(new SearchCountEntity(keyword, 1));
            searchCountPort.saveSearchViewCount(new SearchCountViewEntity(keyword, 1));
        }
    }
}
