package com.configuration.app.service.impl;


import com.configuration.app.mapper.MenuMapper;
import com.configuration.app.persistence.repository.MenuRepository;
import com.configuration.app.service.GoodCategoryService;
import com.configuration.core.data.Void;
import kafka.models.goods.GoodCategoryKafkaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
class GoodCategoryServiceImpl implements GoodCategoryService {

    private final MenuMapper menuMapper;

    private final MenuRepository menuRepository;

    @Override
    public Void add(final GoodCategoryKafkaModel request) {
        return Void.exec(menuRepository::save, menuMapper.fromKafkaModel(request));
    }

    @Override
    public Void delete(final UUID uuid) {
        return Void.exec(menuRepository::deleteById, uuid);
    }
}
