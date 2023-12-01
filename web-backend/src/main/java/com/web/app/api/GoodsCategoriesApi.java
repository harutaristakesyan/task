package com.web.app.api;

import com.web.app.service.model.GoodsCategoriesSearchCriteria;
import com.web.core.api.GetApi;
import com.web.core.api.SearchApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping("/goods/categories")
public interface GoodsCategoriesApi extends SearchApi<GoodsCategoriesSearchCriteria, ResponseEntity<?>> {
}
