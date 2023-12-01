package com.admin.app.api;

import com.admin.app.service.GoodsService;
import com.admin.app.service.model.GoodsSearchCriteria;
import com.admin.core.api.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping("/goods")
public interface GoodsApi extends GetApi<UUID, ResponseEntity<?>>,
        DeleteApi<UUID, ResponseEntity<?>>,
        SearchApi<GoodsSearchCriteria, ResponseEntity<?>>,
        AddApi<GoodsService.GoodRequest, ResponseEntity<?>>,
        UpdateApi<UUID, GoodsService.GoodRequest, ResponseEntity<?>> {
}
