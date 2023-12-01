package com.admin.app.controller;

import com.admin.app.api.GoodsApi;
import com.admin.app.api.GoodsImportExportApi;
import com.admin.app.service.GoodsService;
import com.admin.app.service.model.GoodsSearchCriteria;
import com.admin.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class GoodsController implements GoodsApi , GoodsImportExportApi {

    private final GoodsService goodsService;

    @Override
    public ResponseEntity<?> add(final GoodsService.GoodRequest request) {
        return ResponseUtil.created(goodsService.add(request));
    }

    @Override
    public ResponseEntity<?> get(final UUID id) {
        return ResponseUtil.ok(goodsService.get(id));
    }

    @Override
    public ResponseEntity<?> search(final GoodsSearchCriteria searchModel) {
        return ResponseUtil.ok(goodsService.search(searchModel));
    }

    @Override
    public ResponseEntity<?> update(final UUID id, final GoodsService.GoodRequest request) {
        return ResponseUtil.noContent(goodsService.update(id, request));
    }

    @Override
    public ResponseEntity<?> delete(final UUID id) {
        return ResponseUtil.noContent(goodsService.delete(id));
    }

    @Override
    public ResponseEntity<?> importGoods(final MultipartFile file) {
        return ResponseUtil.created(goodsService.importGoods(file));
    }
}
