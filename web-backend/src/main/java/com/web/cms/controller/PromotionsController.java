package com.web.cms.controller;

import com.web.cms.api.PromotionsApi;
import com.web.cms.service.PromotionsService;
import com.web.cms.service.criteria.PromotionsSearchParameters;
import com.web.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PromotionsController implements PromotionsApi {

    private final PromotionsService promotionsService;

    @Override
    public ResponseEntity<?> search(final PromotionsSearchParameters searchModel) {
        return ResponseUtil.ok(promotionsService.search(searchModel));
    }
}
