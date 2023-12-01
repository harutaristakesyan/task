package com.admin.app.controller;

import com.admin.app.api.GoodsCollectionApi;
import com.admin.app.service.GoodCollectionService;
import com.admin.app.service.model.GoodsCollectionSearchCriteria;
import com.admin.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequiredArgsConstructor
public class GoodsCollectionController implements GoodsCollectionApi {


    private final GoodCollectionService goodCollectionService;

    @Override
    public ResponseEntity<?> add(final GoodCollectionService.GoodCollectionRequest request) {
        return ResponseUtil.created(goodCollectionService.add(request));
    }

    @Override
    public ResponseEntity<?> delete(final UUID id) {
        return ResponseUtil.noContent(goodCollectionService.delete(id));
    }

    @Override
    public ResponseEntity<?> get(final UUID id) {
        return ResponseUtil.ok(goodCollectionService.get(id));
    }

    @Override
    public ResponseEntity<?> search(final GoodsCollectionSearchCriteria searchModel) {
        return ResponseUtil.ok(goodCollectionService.search(searchModel));
    }

    @Override
    public ResponseEntity<?> update(final UUID id, final GoodCollectionService.GoodCollectionRequest request) {
        return ResponseUtil.noContent(goodCollectionService.update(id, request));
    }
}
