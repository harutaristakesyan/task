package com.admin.app.service;

import com.admin.app.data.FileRequest;
import com.admin.app.data.FileResponse;
import com.admin.app.data.TextDto;
import com.admin.app.service.model.GoodsSearchCriteria;
import com.admin.core.data.AbstractListResponse;
import com.admin.core.data.Void;
import com.admin.core.supported.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public interface GoodsService extends AddSupported<GoodsService.GoodRequest, Void>,
        DeleteSupported<UUID, Void>,
        GetSupported<UUID, GoodsService.GoodResponse>,
        UpdateSupported<UUID, GoodsService.GoodRequest, Void>,
        SearchSupported<GoodsSearchCriteria, AbstractListResponse<GoodsService.GoodSearchResponse>> {

    Void importGoods(MultipartFile file);

    record GoodRequest(BigDecimal price, BigDecimal salePrice, String color, String vendorCode, Boolean availability,
                       String finish, String usage, String area, String material, String volume, BigDecimal warranty,
                       UUID category, UUID collection, UUID promotion,
                       Set<FileRequest> images, Set<TextDto> titles, Set<TextDto> descriptions
    ) {
    }

    record GoodResponse(UUID id, BigDecimal price, BigDecimal salePrice, String color, String vendorCode,
                        Boolean availability,
                        String finish, String usage, String area, String material, String volume, BigDecimal warranty,
                        PromotionsService.PromotionResponse promotion, Set<FileResponse> images,
                        GoodCategoryService.GoodCategoryResponse category, Set<TextDto> titles,
                        GoodCollectionService.GoodCollectionResponse collection, Set<TextDto> descriptions
    ) {
    }

    record GoodSearchResponse(UUID id, BigDecimal price, BigDecimal salePrice, String color, String vendorCode,
                              String finish, String usage, String area, String material, String volume,
                              BigDecimal warranty, Boolean availability, String title, String description,
                              GoodCategoryService.GoodCategorySearchResponse category,
                              GoodCollectionService.GoodCollectionResponse collection,
                              PromotionsService.PromotionResponse promotion

    ) {
    }
}
