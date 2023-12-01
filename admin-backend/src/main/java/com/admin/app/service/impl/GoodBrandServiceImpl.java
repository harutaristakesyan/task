package com.admin.app.service.impl;

import com.admin.app.kafka.producer.GoodBrandKafkaProducer;
import com.admin.app.mapper.GoodBrandMapper;
import com.admin.app.persistence.domain.GoodBrandDomain;
import com.admin.app.persistence.repository.GoodBrandRepository;
import com.admin.app.service.GoodBrandService;
import com.admin.app.service.model.GoodsBrandsSearchCriteria;
import com.admin.core.config.ExternalApiProperties;
import com.admin.core.data.AbstractListResponse;
import com.admin.core.data.Void;
import com.admin.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
class GoodBrandServiceImpl implements GoodBrandService {

    private final GoodBrandMapper goodBrandMapper;

    private final GoodBrandRepository goodBrandRepository;

    private final ExternalApiProperties externalApiProperties;

    private final GoodBrandKafkaProducer goodBrandKafkaProducer;

    @Override
    public Void add(final GoodBrandRequest request) {
        final var goodBrandDomain = goodBrandMapper.toEntity(request);
        return Void.exec(goodBrandKafkaProducer::add, goodBrandMapper.toKafkaModel(goodBrandRepository.save(goodBrandDomain)));
    }

    @Override
    public Void delete(final UUID id) {
        final var domain = findDomain(id);
        goodBrandRepository.delete(domain);
        return Void.exec(goodBrandKafkaProducer::delete, goodBrandMapper.toKafkaModel(domain));

    }

    @Override
    public GoodBrandResponse get(final UUID id) {
        return goodBrandMapper.toResponseWhitFile(findDomain(id), externalApiProperties.getFileManagement());
    }

    @Override
    public AbstractListResponse<GoodBrandSearchResponse> search(final GoodsBrandsSearchCriteria searchCriteria) {
        final var goods = goodBrandRepository.findAll(searchCriteria.toPage());
        return ResponseUtil.build(goods.getTotalElements(), goods.stream().map(this::buildResponse).toList());
    }

    @Override
    public Void update(final UUID id, final GoodBrandRequest request) {
        final var domain = findDomain(id);
        goodBrandMapper.updateDomain(domain, request);
        return Void.exec(goodBrandKafkaProducer::add, goodBrandMapper.toKafkaModel(goodBrandRepository.save(domain)));
    }

    private GoodBrandSearchResponse buildResponse(final GoodBrandDomain domain) {
        return goodBrandMapper.toSearchResponseWhitFile(domain, externalApiProperties.getFileManagement());
    }

    private GoodBrandDomain findDomain(final UUID uuid) {
        return goodBrandRepository.findById(uuid).orElseThrow(entityNotFoundException(GoodBrandDomain.class, uuid));
    }
}
