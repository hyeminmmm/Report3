package com.example.report3.serviceapi.searchLocation.adapter.in;

import com.example.report3.common.exception.FailExternalApiRequestException;
import com.example.report3.common.exception.NoParsingException;
import com.example.report3.common.response.CommonApiResponse;
import com.example.report3.common.resultcode.ApiResultCodeEnumCode;
import com.example.report3.serviceapi.searchLocation.adapter.in.dto.SearchLocationResponse;
import com.example.report3.serviceapi.searchLocation.application.port.in.SearchLocationUseCase;
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

    @GetMapping(value = "/location")
    public ResponseEntity<CommonApiResponse<SearchLocationResponse>> getLocations (
            @RequestParam String keyword
    ) throws NoParsingException, FailExternalApiRequestException {
        return new ResponseEntity<>(new CommonApiResponse<>(searchLocationUseCase.getSearchLocation(keyword),
                ApiResultCodeEnumCode.COMMON_SUCCESS_WITHOUT_MESSAGE),
                HttpStatus.OK);
    }

}
