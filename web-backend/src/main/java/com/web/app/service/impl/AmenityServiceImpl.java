package com.web.app.service.impl;


import com.web.app.mapper.AmenityMapper;
import com.web.app.persistence.domain.amenity.AmenityDomain;
import com.web.app.persistence.repository.AmenityRepository;
import com.web.app.service.AmenityService;
import com.web.core.config.CacheNames;
import com.web.core.data.AbstractListResponse;
import com.web.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AmenityServiceImpl implements AmenityService {

    private final AmenityMapper amenityMapper;

    private final AmenityRepository amenityRepository;


    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = CacheNames.AMENITIES, key = "#root.methodName", unless = "#result == null")
    public AbstractListResponse<AmenityResponse> all() {
        final List<AmenityDomain> amenityDomainEntities = amenityRepository.findAll();

        final List<AmenityResponse> amenityResponses = amenityDomainEntities
                .stream()
                .map(amenityMapper::toDto)
                .collect(Collectors.toList());

        amenityResponses.forEach(t -> t.jobs().sort(Comparator.comparingInt(JobResponse::price)));

        return ResponseUtil.build(amenityResponses.size(),amenityResponses);
    }

}
