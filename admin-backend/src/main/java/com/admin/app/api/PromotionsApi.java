package com.admin.app.api;

import com.admin.app.service.PromotionsService;
import com.admin.app.service.model.PromotionsSearchCriteria;
import com.admin.core.api.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping("/promotions")
public interface PromotionsApi extends GetApi<UUID, ResponseEntity<?>>,
        DeleteApi<UUID, ResponseEntity<?>>,
        SearchApi<PromotionsSearchCriteria, ResponseEntity<?>>,
        AddApi<PromotionsService.PromotionsRequest, ResponseEntity<?>>,
        UpdateApi<UUID, PromotionsService.PromotionsRequest, ResponseEntity<?>> {

}
