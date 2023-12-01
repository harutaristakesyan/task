package com.web.app.controller;

import com.web.app.api.GoodsBrandsApi;
import com.web.app.service.GoodBrandService;
import com.web.app.service.model.GoodsBrandsSearchCriteria;
import com.web.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class GoodsBrandsController implements GoodsBrandsApi {

    private final GoodBrandService goodBrandService;

    @Override
    public ResponseEntity<?> get(final UUID id) {
        return ResponseUtil.ok(goodBrandService.get(id));
    }

    @Override
    public ResponseEntity<?> search(final GoodsBrandsSearchCriteria searchModel) {
        return ResponseUtil.ok(goodBrandService.search(searchModel));
    }
}
