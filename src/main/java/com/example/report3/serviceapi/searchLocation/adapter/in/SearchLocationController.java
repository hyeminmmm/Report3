package com.example.report3.serviceapi.searchLocation.adapter.in;

import com.example.report3.common.response.CommonApiResponse;
import com.example.report3.common.resultcode.CommonApiResultCode;
import com.example.report3.serviceapi.searchLocation.adapter.in.dto.SearchLocationDto;
import com.example.report3.serviceapi.searchLocation.application.port.in.SearchLocationUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/report")
@RestController
@RequiredArgsConstructor
public class SearchLocationController {
    private final SearchLocationUseCase searchLocationUseCase;

    @GetMapping("/location")
    public ResponseEntity<CommonApiResponse<SearchLocationDto.SearchLocationResponse>> getLocations (
            @RequestParam String keyword
    ) throws JsonProcessingException {
        return new ResponseEntity<>(new CommonApiResponse<>(searchLocationUseCase.getSearchLocation(keyword),
                CommonApiResultCode.COMMON_SUCCESS_WITHOUT_MESSAGE),
                HttpStatus.OK);
    }

}
