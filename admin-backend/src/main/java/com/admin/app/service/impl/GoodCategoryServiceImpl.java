package com.admin.app.service.impl;

import com.admin.app.kafka.producer.GoodCategoryKafkaProducer;
import com.admin.app.mapper.GoodCategoryMapper;
import com.admin.app.persistence.domain.GoodCategoryDomain;
import com.admin.app.persistence.repository.GoodCategoryRepository;
import com.admin.app.service.GoodCategoryService;
import com.admin.app.service.model.GoodsCategoriesSearchCriteria;
import com.admin.core.data.AbstractListResponse;
import com.admin.core.data.Void;
import com.admin.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
class GoodCategoryServiceImpl implements GoodCategoryService {

    private final GoodCategoryMapper goodCategoryMapper;

    private final GoodCategoryRepository goodCategoryRepository;

    private final GoodCategoryKafkaProducer goodCategoryKafkaProducer;

    @Override
    public Void add(final GoodCategoryRequest request) {
        final var goodCategoryDomain = goodCategoryMapper.toEntity(request);
        return Void.exec(goodCategoryKafkaProducer::add, goodCategoryMapper.toKafkaModel(goodCategoryRepository.save(goodCategoryDomain)));
    }

    @Override
    public Void delete(final UUID uuid) {
        final var domain = findDomain(uuid);
        goodCategoryRepository.delete(domain);
        return Void.exec(goodCategoryKafkaProducer::delete, goodCategoryMapper.toKafkaModel(domain));
    }

    @Override
    public GoodCategoryResponse get(final UUID uuid) {
        return goodCategoryMapper.toResponse(findDomain(uuid));
    }

    @Override
    public AbstractListResponse<GoodCategorySearchResponse> search(final GoodsCategoriesSearchCriteria searchCriteria) {
        final var goods = goodCategoryRepository.findAll(searchCriteria.toPage());
        return ResponseUtil.build(goods.getTotalElements(), goods.stream().map(goodCategoryMapper::toSearchResponse).toList());
    }

    @Override
    public Void update(final UUID uuid, final GoodCategoryRequest request) {
        final var domain = findDomain(uuid);
        goodCategoryMapper.updateDomain(domain, request);
        return Void.exec(goodCategoryKafkaProducer::add, goodCategoryMapper.toKafkaModel(goodCategoryRepository.save(domain)));
    }

    private GoodCategoryDomain findDomain(final UUID uuid) {
        return goodCategoryRepository.findById(uuid).orElseThrow(entityNotFoundException(GoodCategoryDomain.class, uuid));
    }
}
