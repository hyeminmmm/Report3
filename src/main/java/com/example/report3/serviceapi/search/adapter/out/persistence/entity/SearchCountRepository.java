package com.example.report3.serviceapi.search.adapter.out.persistence.entity;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchCountRepository extends JpaRepository<SearchCountEntity, Long> {
    List<SearchCountEntity> findTop10ByOrderByCountDesc();
}
