package com.web.app.service.impl;


import com.web.app.mapper.GoodBrandMapper;
import com.web.app.persistence.domain.GoodBrandDomain;
import com.web.app.persistence.repository.GoodBrandRepository;
import com.web.app.service.GoodBrandService;
import com.web.app.service.model.GoodsBrandsSearchCriteria;
import com.web.core.config.ExternalApiProperties;
import com.web.core.data.AbstractListResponse;
import com.web.core.data.Void;
import com.web.core.util.ResponseUtil;
import kafka.models.goods.GoodBrandKafkaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
class GoodBrandServiceImpl implements GoodBrandService {

    private final GoodBrandMapper goodBrandMapper;

    private final GoodBrandRepository goodBrandRepository;

    private final ExternalApiProperties externalApiProperties;

    @Override
    public Void add(final GoodBrandKafkaModel request) {
        return Void.exec(goodBrandRepository::save, goodBrandMapper.fromKafkaModel(request));
    }

    @Override
    public Void delete(final UUID id) {
        return Void.exec(goodBrandRepository::deleteById, id);
    }

    @Override
    public GoodBrandResponse get(final UUID id) {
        return goodBrandMapper.toResponse(findDomain(id), externalApiProperties.getFileManagement());
    }

    @Override
    public AbstractListResponse<GoodBrandResponse> search(final GoodsBrandsSearchCriteria searchCriteria) {
        final var goods = goodBrandRepository.findAll(searchCriteria.toPage());
        return ResponseUtil.build(goods.getTotalElements(), goods.stream().map(this::buildResponse).toList());
    }


    private GoodBrandResponse buildResponse(final GoodBrandDomain domain) {
        return goodBrandMapper.toResponse(domain, externalApiProperties.getFileManagement());
    }

    private GoodBrandDomain findDomain(final UUID uuid) {
        return goodBrandRepository.findById(uuid).orElseThrow(entityNotFoundException(GoodBrandDomain.class, uuid));
    }
}
