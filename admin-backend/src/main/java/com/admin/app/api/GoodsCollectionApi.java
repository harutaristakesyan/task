package com.admin.app.api;

import com.admin.app.service.GoodCategoryService;
import com.admin.app.service.GoodCollectionService;
import com.admin.app.service.model.GoodsCategoriesSearchCriteria;
import com.admin.app.service.model.GoodsCollectionSearchCriteria;
import com.admin.core.api.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping("/goods/collections")
public interface GoodsCollectionApi extends GetApi<UUID, ResponseEntity<?>>,
        DeleteApi<UUID, ResponseEntity<?>>,
        SearchApi<GoodsCollectionSearchCriteria, ResponseEntity<?>>,
        AddApi<GoodCollectionService.GoodCollectionRequest, ResponseEntity<?>>,
        UpdateApi<UUID, GoodCollectionService.GoodCollectionRequest, ResponseEntity<?>> {
}
