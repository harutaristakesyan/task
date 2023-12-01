package com.um.app.mapper;

import com.um.app.persistence.domain.PermissionDomain;
import com.um.app.persistence.repository.PermissionRepository;
import com.um.app.service.PermissionService;
import com.um.core.mapper.DtoMapper;
import com.um.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface PermissionMapper extends DtoMapper<PermissionService.PermissionResponse, PermissionDomain>, EntityMapper<PermissionService.PermissionRequest, PermissionDomain> {

    @Named("fromId")
    default Set<PermissionDomain> fromId(final Set<UUID> ids) {
        final var permissions = new HashSet<PermissionDomain>();
        for (UUID uuid : ids) {
            PermissionDomain permissionDomain = new PermissionDomain();
            permissionDomain.setId(uuid);
            permissions.add(permissionDomain);
        }
        return permissions;
    }

    @Named("toId")
    default Set<UUID> toId(final Set<PermissionDomain> permissions) {
        final var ids = new HashSet<UUID>();
        for (PermissionDomain permissionDomain : permissions) {
            ids.add(permissionDomain.getId());
        }
        return ids;
    }
}
