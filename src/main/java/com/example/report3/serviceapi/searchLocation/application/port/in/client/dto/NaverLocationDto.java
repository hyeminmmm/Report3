package com.example.report3.serviceapi.searchLocation.application.port.in.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class NaverLocationDto {
    public record parseTest(
            String test
    ) {

    }
    public record SearchNaverLocationResponse(

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
}
