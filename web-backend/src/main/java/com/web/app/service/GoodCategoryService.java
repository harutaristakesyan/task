package com.web.app.service;

import com.web.app.service.model.GoodsCategoriesSearchCriteria;
import com.web.core.data.AbstractListResponse;
import com.web.core.data.Void;
import com.web.core.supported.AddSupported;
import com.web.core.supported.DeleteSupported;
import com.web.core.supported.SearchSupported;
import kafka.models.goods.GoodCategoryKafkaModel;

import java.util.UUID;

public interface GoodCategoryService extends
        DeleteSupported<UUID, Void>,
        AddSupported<GoodCategoryKafkaModel, Void>,
        SearchSupported<GoodsCategoriesSearchCriteria, AbstractListResponse<GoodCategoryService.GoodCategoryResponse>> {

    record GoodCategoryResponse(UUID id, String name, String route) {
    }
}
