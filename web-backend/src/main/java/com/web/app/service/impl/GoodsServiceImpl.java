package com.web.app.service.impl;


import com.web.app.mapper.GoodsMapper;
import com.web.app.persistence.domain.GoodDomain;
import com.web.app.persistence.repository.GoodsRepository;
import com.web.app.service.GoodsService;
import com.web.app.service.model.GoodsSearchCriteria;
import com.web.core.config.ExternalApiProperties;
import com.web.core.data.AbstractListResponse;
import com.web.core.data.Void;
import com.web.core.util.ResponseUtil;
import kafka.models.goods.GoodsKafkaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class GoodsServiceImpl implements GoodsService {

    private final GoodsMapper goodsMapper;

    private final GoodsRepository goodsRepository;

    private final ExternalApiProperties externalApiProperties;

    @Override
    public GoodResponse get(final UUID uuid) {
        return goodsMapper.toResponse(findDomain(uuid), externalApiProperties.getFileManagement());
    }

    @Override
    public AbstractListResponse<GoodResponse> search(final GoodsSearchCriteria searchCriteria) {
        final var goods = goodsRepository.findAll(searchCriteria.toPage());
        return ResponseUtil.build(goods.getTotalElements(), goods.stream().map(this::buildResponse).toList());
    }

    private GoodResponse buildResponse(final GoodDomain domain) {
        return goodsMapper.toResponse(domain, externalApiProperties.getFileManagement());
    }

    private GoodDomain findDomain(final UUID uuid) {
        return goodsRepository.findById(uuid).orElseThrow(entityNotFoundException(GoodDomain.class, uuid));
    }

    @Override
    public Void add(final GoodsKafkaModel request) {
        return Void.exec(goodsRepository::save, goodsMapper.fromKafkaModel(request));
    }

    @Override
    public Void delete(final UUID uuid) {
        return Void.exec(goodsRepository::delete, findDomain(uuid));
    }
}
