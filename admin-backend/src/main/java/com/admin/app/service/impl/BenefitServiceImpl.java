package com.admin.app.service.impl;

import com.admin.app.data.BenefitResponse;
import com.admin.app.mapper.BenefitMapper;
import com.admin.app.persistence.repository.BenefitRepository;
import com.admin.app.service.BenefitService;
import com.admin.core.data.AbstractListResponse;
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
