package com.example.report3.serviceapi.search.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "search_count")
@NoArgsConstructor
public class SearchCountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long searchCountSeq;

    @Getter
    String keyword;
    long count;
    LocalDateTime createdDate;
    LocalDateTime modifiedDate;

    public SearchCountEntity(String keyword, long count) {
        this.keyword = keyword;
        this.count = count;
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
    }
}
