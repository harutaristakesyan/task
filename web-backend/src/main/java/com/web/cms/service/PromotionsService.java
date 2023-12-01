package com.web.cms.service;

import com.web.cms.service.criteria.PromotionsSearchParameters;
import com.web.core.data.AbstractListResponse;
import com.web.core.supported.SearchSupported;

import java.time.LocalDate;

public interface PromotionsService extends SearchSupported<PromotionsSearchParameters, AbstractListResponse<PromotionsService.PromotionResponse>> {

    record PromotionResponse(String id, String text, LocalDate endDate, String image) {
    }

}
