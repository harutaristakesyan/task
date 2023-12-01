package com.web.app.controller;

import com.web.app.api.GoodsCategoriesApi;
import com.web.app.service.GoodCategoryService;
import com.web.app.service.model.GoodsCategoriesSearchCriteria;
import com.web.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class GoodsCategoriesController implements GoodsCategoriesApi {

    private final MongoTemplate mongoTemplate;

    private final GoodCategoryService goodCategoryService;

    @Override
    public ResponseEntity<?> search(final GoodsCategoriesSearchCriteria searchModel) {
        return ResponseUtil.ok(goodCategoryService.search(searchModel));
    }
}
