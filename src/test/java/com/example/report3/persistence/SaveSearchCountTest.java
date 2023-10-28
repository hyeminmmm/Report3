package com.example.report3.persistence;

import com.example.report3.serviceapi.search.adapter.out.persistence.entity.SearchCountEntity;
import com.example.report3.serviceapi.search.adapter.out.persistence.entity.SearchCountViewEntity;
import com.example.report3.serviceapi.search.application.port.in.SearchCountUseCase;
import com.example.report3.serviceapi.search.application.port.out.SearchCountPort;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class SaveSearchCountTest {
    @Autowired
    SearchCountUseCase searchCountUseCase;

    @Autowired
    SearchCountPort searchCountPort;

    @Test
    @Transactional
    public void 조회횟수저장() {
        String keyword = "카카오";
        searchCountUseCase.saveSearchCount(keyword);

        Optional<SearchCountEntity> searchCount = searchCountPort.getSearchCountForUpdate(keyword);
        Optional<SearchCountViewEntity> searchCountView = searchCountPort.getSearchCountView(keyword);

        Assertions.assertEquals(searchCount.get().getCount(), searchCountView.get().getCount());
    }
}
