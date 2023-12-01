package com.web.cms.service.impl;

import com.web.cms.mapper.BenefitMapper;
import com.web.cms.persistence.repository.BenefitRepository;
import com.web.cms.service.BenefitService;
import com.web.core.data.AbstractListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BenefitServiceImpl implements BenefitService {

    private final BenefitMapper benefitMapper;

    private final BenefitRepository benefitRepository;

    @Override
    @Cacheable("benefits")
    public AbstractListResponse<BenefitResponse> all() {


        return null;
    }
}
