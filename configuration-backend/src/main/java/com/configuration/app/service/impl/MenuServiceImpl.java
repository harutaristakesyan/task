package com.configuration.app.service.impl;

import com.configuration.app.kafka.producer.MenuKafkaProducer;
import com.configuration.app.mapper.MenuMapper;
import com.configuration.app.persistence.domain.MenuDomain;
import com.configuration.app.persistence.repository.MenuRepository;
import com.configuration.app.service.MenuService;
import com.configuration.app.service.model.MenuSearchCriteria;
import com.configuration.core.data.AbstractListResponse;
import com.configuration.core.data.Void;
import com.configuration.core.util.ResponseUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;

    private final MenuRepository menuRepository;

    private final MenuKafkaProducer menuKafkaProducer;

    @Override
    public Void add(final MenuRequest request) {
        final var menuDomain = menuMapper.toEntity(request);
        return Void.exec(menuKafkaProducer::add, menuMapper.toKafkaModel(menuRepository.save(menuDomain)));
    }

    @Override
    public Void delete(final UUID id) {
        final var domain = findDomain(id);
        menuRepository.delete(domain);
        return Void.exec(menuKafkaProducer::delete, menuMapper.toKafkaModel(domain));
    }

    @Override
    public MenuResponse get(final UUID id) {
        return menuMapper.toResponse(findDomain(id));
    }

    @Override
    public AbstractListResponse<MenuSearchResponse> search(final MenuSearchCriteria searchCriteria) {
        final var menuDomains = menuRepository.findAll(searchCriteria.toPage());
        return ResponseUtil.build(menuDomains.getTotalElements(), menuDomains.stream().map(this::buildResponse).toList());
    }

    @Override
    public Void update(final UUID id, final MenuRequest request) {
        final var domain = findDomain(id);
        menuMapper.updateDomain(domain, request);
        return Void.exec(menuKafkaProducer::add, menuMapper.toKafkaModel(menuRepository.save(domain)));
    }

    private MenuSearchResponse buildResponse(final MenuDomain domain) {
        return menuMapper.toSearchResponse(domain);
    }

    private MenuDomain findDomain(final UUID uuid) {
        return menuRepository.findById(uuid).orElseThrow(entityNotFoundException(MenuDomain.class, uuid));
    }
}
