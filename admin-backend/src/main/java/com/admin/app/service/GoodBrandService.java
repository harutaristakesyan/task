package com.admin.app.service;

import com.admin.app.data.FileRequest;
import com.admin.app.data.FileResponse;
import com.admin.app.data.TextDto;
import com.admin.app.service.model.GoodsBrandsSearchCriteria;
import com.admin.core.data.AbstractListResponse;
import com.admin.core.data.Void;
import com.admin.core.supported.*;

import java.util.Set;
import java.util.UUID;

public interface GoodBrandService extends AddSupported<GoodBrandService.GoodBrandRequest, Void>,
        DeleteSupported<UUID, Void>,
        GetSupported<UUID, GoodBrandService.GoodBrandResponse>,
        UpdateSupported<UUID, GoodBrandService.GoodBrandRequest, Void>,
        SearchSupported<GoodsBrandsSearchCriteria, AbstractListResponse<GoodBrandService.GoodBrandSearchResponse>> {

    record GoodBrandRequest(String name, String route, String countryOfOrigin, FileRequest logo,
                            Set<TextDto> descriptions) {

    }

    record GoodBrandResponse(UUID id, String name, String route, String countryOfOrigin, FileResponse logo,
                             Set<TextDto> descriptions) {
    }

    record GoodBrandSearchResponse(UUID id, String name, String route, String countryOfOrigin, FileResponse logo,
                                   String description) {
    }

}
