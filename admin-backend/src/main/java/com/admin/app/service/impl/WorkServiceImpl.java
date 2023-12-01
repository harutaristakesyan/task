package com.admin.app.service.impl;

import com.admin.app.data.WorkResponse;
import com.admin.app.mapper.WorkMapper;
import com.admin.app.persistence.domain.WorkDomain;
import com.admin.app.persistence.repository.WorkRepository;
import com.admin.app.service.WorkService;
import com.admin.core.data.AbstractListResponse;
import com.admin.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkServiceImpl implements WorkService {

    private final WorkMapper workMapper;

    private final WorkRepository workRepository;

    @Override
    @Cacheable("works")
    public AbstractListResponse<WorkResponse> all() {
        final List<WorkDomain> workDomainList = workRepository.findAll();

        return ResponseUtil.build(workDomainList.size(),
                workDomainList.stream().map(workMapper::toResponse)
                        .toList());
    }
}
