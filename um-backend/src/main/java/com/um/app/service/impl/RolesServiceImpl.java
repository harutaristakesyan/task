package com.um.app.service.impl;

import com.um.app.mapper.RoleMapper;;
import com.um.app.persistence.domain.PermissionDomain;
import com.um.app.persistence.domain.RoleDomain;
import com.um.app.persistence.repository.RoleRepository;
import com.um.app.service.RolesService;
import com.um.core.data.AbstractListResponse;
import com.um.core.data.Void;
import com.um.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RolesServiceImpl implements RolesService {

    private final RoleMapper roleMapper;

    private final RoleRepository roleRepository;

    @Override
    public Void add(final RoleRequest request) {
        return Void.exec(roleRepository.save(roleMapper::toEntity), request);
    }

    @Override
    public RoleResponse get(final UUID uuid) {
        return roleMapper.toResponse(findDomain(uuid));
    }

    @Override
    public Void update(final UUID uuid, RoleRequest request) {
        final var domain = findDomain(uuid);
        return Void.exec(roleRepository.save(roleMapper::updateDomain), domain, request);
    }

    @Override
    public AbstractListResponse<RoleResponse> search(final RoleSearchCriteria searchCriteria) {
        final var permissions = roleRepository.findAll(searchCriteria.toPage());
        return ResponseUtil.build(permissions.getTotalElements(), permissions.stream().map(roleMapper::toResponse).toList());
    }


    @Override
    public Void delete(final UUID uuid) {
        return Void.exec(roleRepository::deleteById, uuid);
    }

    private RoleDomain findDomain(final UUID uuid) {
        return roleRepository.findById(uuid)
                .orElseThrow(entityNotFoundException(RoleDomain.class, uuid, Map.of()));
    }

}
