package com.admin.app.controller;

import com.admin.app.api.GoodsBrandsApi;
import com.admin.app.service.GoodBrandService;
import com.admin.app.service.model.GoodsBrandsSearchCriteria;
import com.admin.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class GoodsBrandsController implements GoodsBrandsApi {

    private final GoodBrandService goodBrandService;

    @Override
    public ResponseEntity<?> add(final GoodBrandService.GoodBrandRequest request) {
        return ResponseUtil.created(goodBrandService.add(request));
    }

    @Override
    public ResponseEntity<?> delete(final UUID id) {
        return ResponseUtil.noContent(goodBrandService.delete(id));
    }

    @Override
    public ResponseEntity<?> get(final UUID id) {
        return ResponseUtil.ok(goodBrandService.get(id));
    }

    @Override
    public ResponseEntity<?> search(final GoodsBrandsSearchCriteria searchModel) {
        return ResponseUtil.ok(goodBrandService.search(searchModel));
    }

    @Override
    public ResponseEntity<?> update(final UUID id, final GoodBrandService.GoodBrandRequest request) {
        return ResponseUtil.noContent(goodBrandService.update(id, request));
    }
}
