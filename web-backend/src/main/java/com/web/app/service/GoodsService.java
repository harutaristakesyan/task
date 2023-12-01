package com.web.app.service;

import com.web.app.data.FileResponse;
import com.web.app.service.model.GoodsSearchCriteria;
import com.web.core.data.AbstractListResponse;
import com.web.core.data.Void;
import com.web.core.supported.AddSupported;
import com.web.core.supported.DeleteSupported;
import com.web.core.supported.GetSupported;
import com.web.core.supported.SearchSupported;
import kafka.models.goods.GoodsKafkaModel;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public interface GoodsService extends
        DeleteSupported<UUID, Void>,
        AddSupported<GoodsKafkaModel, Void>,
        GetSupported<UUID, GoodsService.GoodResponse>,
        SearchSupported<GoodsSearchCriteria, AbstractListResponse<GoodsService.GoodResponse>> {


    record GoodResponse(UUID id, BigDecimal price, GoodCategoryService.GoodCategoryResponse category,
                        Set<FileResponse> images, GoodBrandService.GoodBrandResponse brand, String vendorCode,
                        BigDecimal salePrice, BigDecimal discount, String color, String finish, String material,
                        String usage, String area, FileResponse catalog, String volume, Boolean availability,
                        BigDecimal warranty, String title, String description) {
    }
}
