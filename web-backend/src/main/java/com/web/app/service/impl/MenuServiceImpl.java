package com.web.app.service.impl;

import com.web.app.mapper.MenuMapper;
import com.web.app.persistence.domain.MenuDomain;
import com.web.app.persistence.repository.MenuRepository;
import com.web.app.service.MenuService;
import com.web.app.service.model.MenuSearchCriteria;
import com.web.core.data.AbstractListResponse;
import com.web.core.data.Void;
import com.web.core.util.ResponseUtil;
import kafka.models.menu.MenuKafkaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;

    private final MenuRepository menuRepository;

    @Override
    public Void add(final MenuKafkaModel request) {
        return Void.exec(menuRepository::save, menuMapper.fromKafkaModel(request));
    }

    @Override
    public Void delete(final UUID id) {
        return Void.exec(menuRepository::deleteById, id);
    }

    @Override
    public AbstractListResponse<MenuSearchResponse> search(final MenuSearchCriteria searchCriteria) {
        final var domains = menuRepository.findAll(searchCriteria.toPage());
        return ResponseUtil.build(domains.getTotalElements(), domains.stream().map(this::buildResponse).toList());
    }

    private MenuSearchResponse buildResponse(final MenuDomain domain) {
        return menuMapper.toSearchResponse(domain);
    }
}
