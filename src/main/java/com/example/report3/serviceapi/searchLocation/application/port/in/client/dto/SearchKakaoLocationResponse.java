package com.example.report3.serviceapi.searchLocation.application.port.in.client.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record SearchKakaoLocationResponse (
        Meta meta,
        List<Documents> documents
    ) {
        public record Meta(
                @JsonProperty("total_count")
                Integer totalCount,

                @JsonProperty("pageableCount")
                Integer pageableCount,

                @JsonProperty("is_end")
                Boolean isEnd,

                @JsonProperty("same_name")
                SameName sameName
        ) {
            public record SameName(
                    List<String> region,
                    String keyword,

                    @JsonProperty("selectedRegion")
                    String selectedRegion
            ) {
            }
        }

        public record Documents(
                String id,

                @JsonProperty("place_name")
                String placeName,

                @JsonProperty("category_name")
                String categoryName,

                @JsonProperty("category_group_code")
                String categoryGroupCode,

                @JsonProperty("category_group_name")
                String categoryGroupName,

                String phone,

                @JsonProperty("address_name")
                String addressName,

                @JsonProperty("road_address_name")
                String roadAddressName,

                String x,
                String y,

                @JsonProperty("place_url")
                String placeUrl,

                String distance
        ) {}
}
