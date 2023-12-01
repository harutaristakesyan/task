package com.web.app.service.impl;

import com.web.app.mapper.ServiceMapper;
import com.web.app.persistence.domain.ServiceDomain;
import com.web.app.persistence.repository.ServiceRepository;
import com.web.app.service.ServiceService;
import com.web.core.data.AbstractListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceMapper serviceMapper;

    private final ServiceRepository serviceRepository;

    @Override
    @Cacheable("services")
    public AbstractListResponse<ServiceResponse> all() {

        final List<ServiceDomain> serviceEntities = serviceRepository.findAllByOrderByPriceAsc();

        return new AbstractListResponse<>(
                serviceEntities.size(),
                serviceEntities
                        .stream()
                        .map(serviceMapper::toDto)
                        .collect(Collectors.toList())
        );
    }
}
