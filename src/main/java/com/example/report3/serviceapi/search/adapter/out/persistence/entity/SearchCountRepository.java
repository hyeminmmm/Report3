package com.example.report3.serviceapi.search.adapter.out.persistence.entity;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface SearchCountRepository extends JpaRepository<SearchCountEntity, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<SearchCountEntity> findByKeyword(String keyword);

}
