package com.web.app.service.impl;

import com.web.app.mapper.WorkMapper;
import com.web.app.persistence.domain.WorkDomain;
import com.web.app.persistence.repository.WorkRepository;
import com.web.app.service.WorkService;
import com.web.core.data.AbstractListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class WorkServiceImpl implements WorkService {

    private final WorkMapper workMapper;

    private final WorkRepository workRepository;

    @Override
    @Cacheable("works")
    public AbstractListResponse<WorkResponse> all() {
        final List<WorkDomain> workEntityList = workRepository.findAll();

        return new AbstractListResponse<>(workEntityList.size(), workEntityList
                .stream()
                .map(workMapper::toDto)
                .collect(Collectors.toList()));
    }
}
