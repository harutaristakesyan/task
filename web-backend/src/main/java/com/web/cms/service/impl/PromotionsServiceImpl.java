package com.web.cms.service.impl;

import com.web.cms.mapper.PromotionMapper;
import com.web.cms.persistence.domain.PromotionDomain;
import com.web.cms.persistence.repository.PromotionRepository;
import com.web.cms.service.PromotionsService;
import com.web.cms.service.criteria.PromotionsSearchParameters;
import com.web.core.data.AbstractListResponse;
import com.web.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class PromotionsServiceImpl implements PromotionsService {

    private final PromotionMapper promotionMapper;

    private final PromotionRepository promotionRepository;

    @Override
    public AbstractListResponse<PromotionResponse> search(final PromotionsSearchParameters promotionsSearchParameters) {
        final var promotionDomains = promotionRepository.findAll(promotionsSearchParameters.toPage());
        return ResponseUtil.build(promotionDomains.getTotalElements(), promotionDomains.getContent().stream().map(promotionMapper::toDto).toList());
    }
}
