package com.admin.app.service.impl;

import com.admin.app.kafka.producer.GoodCollectionKafkaProducer;
import com.admin.app.mapper.GoodsCollectionMapper;
import com.admin.app.persistence.domain.GoodCollectionDomain;
import com.admin.app.persistence.repository.GoodCollectionRepository;
import com.admin.app.service.GoodCollectionService;
import com.admin.app.service.model.GoodsCollectionSearchCriteria;
import com.admin.core.config.ExternalApiProperties;
import com.admin.core.data.AbstractListResponse;
import com.admin.core.data.Void;
import com.admin.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
class GoodCollectionServiceImpl implements GoodCollectionService {


    private final ExternalApiProperties externalApiProperties;

    private final GoodsCollectionMapper goodsCollectionMapper;

    private final GoodCollectionRepository goodCollectionRepository;

    private final GoodCollectionKafkaProducer goodCollectionKafkaProducer;

    @Override
    public Void add(final GoodCollectionRequest request) {
        final var goodCollectionDomain = goodsCollectionMapper.toEntity(request);
        return Void.exec(goodCollectionKafkaProducer::add, goodsCollectionMapper.toKafkaModel(goodCollectionRepository.save(goodCollectionDomain)));
    }

    @Override
    public Void delete(final UUID uuid) {
        final var domain = findDomain(uuid);
        goodCollectionRepository.delete(domain);
        return Void.exec(goodCollectionKafkaProducer::delete, goodsCollectionMapper.toKafkaModel(domain));
    }

    @Override
    public GoodCollectionResponse get(final UUID uuid) {
        return goodsCollectionMapper.toResponseWhitFile(findDomain(uuid), externalApiProperties.getFileManagement());
    }

    @Override
    public AbstractListResponse<GoodCollectionSearchResponse> search(final GoodsCollectionSearchCriteria searchCriteria) {
        final var goods = goodCollectionRepository.findAll(searchCriteria.toPage());
        return ResponseUtil.build(goods.getTotalElements(), goods.stream().map(goodsCollectionMapper::toSearchResponse).toList());
    }

    @Override
    public Void update(final UUID uuid, final GoodCollectionService.GoodCollectionRequest request) {
        final var domain = findDomain(uuid);
        goodsCollectionMapper.updateDomain(domain, request);
        return Void.exec(goodCollectionKafkaProducer::add, goodsCollectionMapper.toKafkaModel(goodCollectionRepository.save(domain)));
    }

    private GoodCollectionDomain findDomain(final UUID uuid) {
        return goodCollectionRepository.findById(uuid).orElseThrow(entityNotFoundException(GoodCollectionDomain.class, uuid));
    }
}
