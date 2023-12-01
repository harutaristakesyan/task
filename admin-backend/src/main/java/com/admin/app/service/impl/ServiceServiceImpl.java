package com.admin.app.service.impl;

import com.admin.app.mapper.ServiceMapper;
import com.admin.app.persistence.domain.ServiceDomain;
import com.admin.app.persistence.repository.ServiceRepository;
import com.admin.app.service.ServiceService;
import com.admin.core.data.AbstractListResponse;
import com.admin.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceMapper serviceMapper;

    private final ServiceRepository serviceRepository;

    @Override
    @Cacheable("services")
    public AbstractListResponse<ServiceResponse> all() {
        final List<ServiceDomain> serviceEntities = serviceRepository.findAllByOrderByPriceAsc();

        return ResponseUtil.build(serviceEntities.size(),
                serviceEntities.stream().map(serviceMapper::toResponse).toList());
    }
}
