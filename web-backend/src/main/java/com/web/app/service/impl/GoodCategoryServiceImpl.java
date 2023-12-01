package com.web.app.service.impl;

import com.web.app.mapper.GoodCategoryMapper;
import com.web.app.persistence.domain.GoodCategoryDomain;
import com.web.app.persistence.repository.GoodCategoryRepository;
import com.web.app.service.GoodCategoryService;
import com.web.app.service.model.GoodsCategoriesSearchCriteria;
import com.web.core.data.AbstractListResponse;
import com.web.core.data.Void;
import com.web.core.util.ResponseUtil;
import kafka.models.goods.GoodCategoryKafkaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
class GoodCategoryServiceImpl implements GoodCategoryService {

    private final MongoTemplate mongoTemplate;

    private final GoodCategoryMapper goodCategoryMapper;

    private final GoodCategoryRepository goodCategoryRepository;

    @Override
    public AbstractListResponse<GoodCategoryResponse> search(final GoodsCategoriesSearchCriteria searchModel) {

        final var query = new Query().with(searchModel.toPage());

        if (!searchModel.getName().isEmpty()) {
            final var criteria = Criteria.where("name").regex(searchModel.getName());
            query.addCriteria(criteria);
        }

        final var goods = mongoTemplate.find(query, GoodCategoryDomain.class);
        return ResponseUtil.build(goods.size(), goods.stream().map(goodCategoryMapper::toResponse).toList());
    }

    @Override
    public Void add(final GoodCategoryKafkaModel request) {
        return Void.exec(goodCategoryRepository::save, goodCategoryMapper.fromKafkaModel(request));
    }

    @Override
    public Void delete(final UUID uuid) {
        return Void.exec(goodCategoryRepository::deleteById, uuid);
    }
}
