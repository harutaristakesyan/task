package com.admin.app.service;

import com.admin.app.data.FileRequest;
import com.admin.app.data.FileResponse;
import com.admin.app.data.PromotionType;
import com.admin.app.data.TextDto;
import com.admin.app.service.model.PromotionsSearchCriteria;
import com.admin.core.data.AbstractListResponse;
import com.admin.core.data.Void;
import com.admin.core.supported.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public interface PromotionsService extends AddSupported<PromotionsService.PromotionsRequest, Void>,
        DeleteSupported<UUID, Void>,
        GetSupported<UUID, PromotionsService.PromotionResponse>,
        UpdateSupported<UUID, PromotionsService.PromotionsRequest, Void>,
        SearchSupported<PromotionsSearchCriteria, AbstractListResponse<PromotionsService.PromotionSearchResponse>> {

    record PromotionsRequest(Set<TextDto> texts, LocalDate endDate, String value, String route,
                             PromotionType type, FileRequest image) {

    }

    record PromotionResponse(UUID id, Set<TextDto> texts, LocalDate endDate, String value, PromotionType type,
                             String route, FileResponse image) {
    }

    record PromotionSearchResponse(UUID id, String text, LocalDate endDate, PromotionType type, String value,
                                   String route, FileResponse image) {
    }
}
