package com.example.report3.serviceapi.searchLocation.application.port.in.client.dto;

import java.util.List;

public record SearchNaverLocationResponse (
        Integer total,
        String lastBuildDate,
        Integer display,
        Integer start,
        List<Item> items
        ) {
        public record Item(
            String title,
            String link,
            String category,
            String description,
            String telephone,
            String address,
            String roadAddress,
            String mapx,
            String mapy
            ) {}
}