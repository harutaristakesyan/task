package com.admin.app.controller;

import com.admin.app.api.GoodsCategoriesApi;
import com.admin.app.service.GoodCategoryService;
import com.admin.app.service.model.GoodsCategoriesSearchCriteria;
import com.admin.core.data.Void;
import com.admin.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class GoodsCategoriesController implements GoodsCategoriesApi {

    private final GoodCategoryService goodCategoryService;

    @Override
    public ResponseEntity<?> add(final GoodCategoryService.GoodCategoryRequest request) {
        return ResponseUtil.created(goodCategoryService.add(request));
    }

    @Override
    public ResponseEntity<?> delete(final UUID id) {
        return ResponseUtil.noContent(goodCategoryService.delete(id));
    }

    @Override
    public ResponseEntity<?> get(final UUID id) {
        return ResponseUtil.ok(goodCategoryService.get(id));
    }

    @Override
    public ResponseEntity<?> search(final GoodsCategoriesSearchCriteria searchModel) {
        return ResponseUtil.ok(goodCategoryService.search(searchModel));
    }

    @Override
    public ResponseEntity<?> update(final UUID id, final GoodCategoryService.GoodCategoryRequest request) {
        return ResponseUtil.noContent(goodCategoryService.update(id, request));
    }
}
