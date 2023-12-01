package com.um.app.service.impl;

import com.um.app.mapper.PermissionMapper;
import com.um.app.persistence.domain.PermissionDomain;
import com.um.app.persistence.repository.PermissionRepository;
import com.um.app.service.PermissionService;
import com.um.core.data.AbstractListResponse;
import com.um.core.data.Void;
import com.um.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionMapper permissionMapper;

    private final PermissionRepository permissionRepository;

    @Override
    public Void add(final PermissionRequest request) {
        return Void.exec(permissionRepository.save(permissionMapper::toEntity), request);
    }

    @Override
    public PermissionResponse get(final UUID uuid) {
        return permissionMapper.toResponse(findDomain(uuid));
    }

    @Override
    public Void update(final UUID uuid, final PermissionRequest request) {
        final var domain = findDomain(uuid);
        return Void.exec(permissionRepository.save(permissionMapper::updateDomain), domain, request);
    }

    @Override
    public AbstractListResponse<PermissionResponse> search(final PermissionSearchCriteria searchCriteria) {
        final var permissions = permissionRepository.findAll(searchCriteria.toPage());
        return ResponseUtil.build(permissions.getTotalElements(), permissions.stream().map(permissionMapper::toResponse).toList());
    }

    @Override
    public Void delete(final UUID uuid) {
        return Void.exec(permissionRepository::deleteById, uuid);
    }

    private PermissionDomain findDomain(final UUID uuid) {
        return permissionRepository.findById(uuid)
                .orElseThrow(entityNotFoundException(PermissionDomain.class, uuid, Map.of()));
    }
}
