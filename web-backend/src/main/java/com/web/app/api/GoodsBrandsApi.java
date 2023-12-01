package com.web.app.api;

import com.web.app.service.model.GoodsBrandsSearchCriteria;
import com.web.core.api.GetApi;
import com.web.core.api.SearchApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping("/goods/brands")
public interface GoodsBrandsApi extends GetApi<UUID, ResponseEntity<?>>,
        SearchApi<GoodsBrandsSearchCriteria, ResponseEntity<?>> {
}
