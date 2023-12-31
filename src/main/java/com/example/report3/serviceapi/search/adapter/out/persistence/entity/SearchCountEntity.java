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
    private long searchCountSeq;

    @Getter
    private String keyword;
    @Getter
    private long count;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public SearchCountEntity(String keyword, long count) {
        this.keyword = keyword;
        this.count = count;
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
    }

    public void updateCount(long count) {
        this.count = count;
        this.modifiedDate = LocalDateTime.now();
    }
}
