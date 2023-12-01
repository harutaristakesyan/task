package com.admin.app.api;

import com.admin.app.service.GoodBrandService;
import com.admin.app.service.model.GoodsBrandsSearchCriteria;
import com.admin.core.api.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping("/goods/brands")
public interface GoodsBrandsApi extends GetApi<UUID, ResponseEntity<?>>,
        DeleteApi<UUID, ResponseEntity<?>>,
        SearchApi<GoodsBrandsSearchCriteria, ResponseEntity<?>>,
        AddApi<GoodBrandService.GoodBrandRequest, ResponseEntity<?>>,
        UpdateApi<UUID, GoodBrandService.GoodBrandRequest, ResponseEntity<?>> {
}
