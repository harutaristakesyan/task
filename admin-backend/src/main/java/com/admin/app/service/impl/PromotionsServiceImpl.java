package com.admin.app.service.impl;

import com.admin.app.kafka.producer.PromotionKafkaProducer;
import com.admin.app.mapper.PromotionMapper;
import com.admin.app.persistence.domain.PromotionDomain;
import com.admin.app.persistence.repository.PromotionRepository;
import com.admin.app.service.PromotionsService;
import com.admin.app.service.model.PromotionsSearchCriteria;
import com.admin.core.config.ExternalApiProperties;
import com.admin.core.data.AbstractListResponse;
import com.admin.core.data.Void;
import com.admin.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PromotionsServiceImpl implements PromotionsService {


    private final PromotionMapper promotionMapper;

    private final PromotionRepository promotionRepository;

    private final ExternalApiProperties externalApiProperties;

    private final PromotionKafkaProducer promotionKafkaProducer;

    @Override
    public Void add(final PromotionsRequest request) {
        final var domain = promotionMapper.toEntity(request);
        return Void.exec(promotionKafkaProducer::add, promotionMapper.toKafkaModel(promotionRepository.save(domain)));
    }

    @Override
    public Void delete(final UUID id) {
        final var domain = findDomain(id);
        promotionRepository.delete(domain);
        return Void.exec(promotionKafkaProducer::delete, promotionMapper.toKafkaModel(domain));
    }

    @Override
    public PromotionResponse get(final UUID id) {
        return promotionMapper.toResponseWhitFile(findDomain(id), externalApiProperties.getFileManagement());
    }

    @Override
    public AbstractListResponse<PromotionSearchResponse> search(final PromotionsSearchCriteria searchCriteria) {
        final var page = promotionRepository.findAll(searchCriteria.toPage());
        return ResponseUtil.build(page.getTotalElements(), page.stream().map(promotionMapper::toSearchResponse).toList());
    }

    @Override
    public Void update(final UUID uuid, final PromotionsRequest request) {
        final var domain = findDomain(uuid);
        promotionMapper.updateDomain(domain, request);
        return Void.exec(promotionKafkaProducer::add, promotionMapper.toKafkaModel(promotionRepository.save(domain)));
    }

    private PromotionDomain findDomain(final UUID uuid) {
        return promotionRepository.findById(uuid).orElseThrow(entityNotFoundException(PromotionDomain.class, uuid));
    }
}
