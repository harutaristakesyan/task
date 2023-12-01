package com.admin.app.service;

import com.admin.app.data.TextDto;
import com.admin.app.service.model.GoodsCategoriesSearchCriteria;
import com.admin.core.data.AbstractListResponse;
import com.admin.core.data.Void;
import com.admin.core.supported.*;

import java.util.Set;
import java.util.UUID;

public interface GoodCategoryService extends AddSupported<GoodCategoryService.GoodCategoryRequest, Void>,
        DeleteSupported<UUID, Void>,
        GetSupported<UUID, GoodCategoryService.GoodCategoryResponse>,
        UpdateSupported<UUID, GoodCategoryService.GoodCategoryRequest, Void>,
        SearchSupported<GoodsCategoriesSearchCriteria, AbstractListResponse<GoodCategoryService.GoodCategorySearchResponse>> {

    record GoodCategoryRequest(Set<TextDto> names, String route) {
    }

    record GoodCategoryResponse(UUID id, Set<TextDto> names, String route) {
    }

    record GoodCategorySearchResponse(UUID id, String name, String route) {
    }
}
