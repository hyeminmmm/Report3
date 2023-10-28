package com.example.report3.serviceapi.search.adapter.in;

import com.example.report3.common.response.CommonApiResponse;
import com.example.report3.common.resultcode.ApiResultCodeEnumCode;
import com.example.report3.serviceapi.search.adapter.in.dto.SearchCountResponse;
import com.example.report3.serviceapi.search.application.port.in.SearchCountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/search")
@RestController
@RequiredArgsConstructor
public class SearchCountController {
    private final SearchCountUseCase searchCountUseCase;

    @GetMapping(value = "/count")
    public ResponseEntity<CommonApiResponse<SearchCountResponse>> getSearchCountHistory() {
        return new ResponseEntity<>(new CommonApiResponse<>(
                searchCountUseCase.getSearchCountViews(),
                ApiResultCodeEnumCode.COMMON_SUCCESS_WITHOUT_MESSAGE),
                HttpStatus.OK);
    }
}
