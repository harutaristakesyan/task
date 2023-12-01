package com.admin.app.api;

import com.admin.app.service.GoodCategoryService;
import com.admin.app.service.model.GoodsCategoriesSearchCriteria;
import com.admin.core.api.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping("/goods/categories")
public interface GoodsCategoriesApi extends GetApi<UUID, ResponseEntity<?>>,
        DeleteApi<UUID, ResponseEntity<?>>,
        SearchApi<GoodsCategoriesSearchCriteria, ResponseEntity<?>>,
        AddApi<GoodCategoryService.GoodCategoryRequest, ResponseEntity<?>>,
        UpdateApi<UUID, GoodCategoryService.GoodCategoryRequest, ResponseEntity<?>> {
}
