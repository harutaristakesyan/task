package com.admin.app.service;

import com.admin.app.data.FileRequest;
import com.admin.app.data.FileResponse;
import com.admin.app.service.model.GoodsCollectionSearchCriteria;
import com.admin.core.data.AbstractListResponse;
import com.admin.core.data.Void;
import com.admin.core.supported.*;

import java.util.UUID;

public interface GoodCollectionService extends AddSupported<GoodCollectionService.GoodCollectionRequest, Void>,
        DeleteSupported<UUID, Void>,
        GetSupported<UUID, GoodCollectionService.GoodCollectionResponse>,
        UpdateSupported<UUID, GoodCollectionService.GoodCollectionRequest, Void>,
        SearchSupported<GoodsCollectionSearchCriteria, AbstractListResponse<GoodCollectionService.GoodCollectionSearchResponse>> {

    record GoodCollectionRequest(String name, String route, UUID brand, FileRequest catalog) {
    }

    record GoodCollectionResponse(UUID id, String name, String route, FileResponse catalog,
                                  GoodBrandService.GoodBrandResponse brand) {
    }

    record GoodCollectionSearchResponse(UUID id, String name, String route,
                                        GoodBrandService.GoodBrandSearchResponse brand) {
    }
}
