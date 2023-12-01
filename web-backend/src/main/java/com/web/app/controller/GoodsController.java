package com.web.app.controller;


import com.web.app.api.GoodsApi;
import com.web.app.service.GoodsService;
import com.web.app.service.model.GoodsSearchCriteria;
import com.web.core.data.AbstractListResponse;
import com.web.core.data.BaseResponse;
import com.web.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class GoodsController implements GoodsApi {

    private final GoodsService goodsService;

    @Override
    public ResponseEntity<?> get(final UUID id) {
        return ResponseUtil.ok(goodsService.get(id));
    }

    @Override
    public ResponseEntity<?> search(final GoodsSearchCriteria searchModel) {
        return ResponseUtil.ok(goodsService.search(searchModel));
    }

}
