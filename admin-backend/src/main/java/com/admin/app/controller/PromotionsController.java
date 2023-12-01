package com.admin.app.controller;

import com.admin.app.api.PromotionsApi;
import com.admin.app.service.PromotionsService;
import com.admin.app.service.model.PromotionsSearchCriteria;
import com.admin.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PromotionsController implements PromotionsApi {

    private final PromotionsService promotionsService;

    @Override
    public ResponseEntity<?> add(final PromotionsService.PromotionsRequest request) {
        return ResponseUtil.created(promotionsService.add(request));
    }

    @Override
    public ResponseEntity<?> delete(final UUID id) {
        return ResponseUtil.noContent(promotionsService.delete(id));
    }

    @Override
    public ResponseEntity<?> get(final UUID id) {
        return ResponseUtil.ok(promotionsService.get(id));
    }

    @Override
    public ResponseEntity<?> search(final PromotionsSearchCriteria searchModel) {
        return ResponseUtil.ok(promotionsService.search(searchModel));
    }

    @Override
    public ResponseEntity<?> update(final UUID id, final PromotionsService.PromotionsRequest request) {
        return ResponseUtil.noContent(promotionsService.update(id, request));
    }
}
