package com.example.report3.serviceapi.search.adapter.out.persistence.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SearchCountViewRepository extends JpaRepository<SearchCountViewEntity, Long> {
    List<SearchCountViewEntity> findTop10ByOrderByCountDesc();
    Optional<SearchCountViewEntity> findByKeyword(String keyword);
}
