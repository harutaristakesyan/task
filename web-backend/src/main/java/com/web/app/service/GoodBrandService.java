package com.web.app.service;


import com.web.app.data.FileResponse;
import com.web.app.service.model.GoodsBrandsSearchCriteria;
import com.web.core.data.AbstractListResponse;
import com.web.core.data.Void;
import com.web.core.supported.AddSupported;
import com.web.core.supported.DeleteSupported;
import com.web.core.supported.GetSupported;
import com.web.core.supported.SearchSupported;
import kafka.models.goods.GoodBrandKafkaModel;

import java.util.UUID;

public interface GoodBrandService extends AddSupported<GoodBrandKafkaModel, Void>,
        DeleteSupported<UUID, Void>,
        GetSupported<UUID, GoodBrandService.GoodBrandResponse>,
        SearchSupported<GoodsBrandsSearchCriteria, AbstractListResponse<GoodBrandService.GoodBrandResponse>> {

    record GoodBrandResponse(UUID id, String name, String route, String countryOfOrigin, FileResponse logo,
                             String description) {
    }

}
