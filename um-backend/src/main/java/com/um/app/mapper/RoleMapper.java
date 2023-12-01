package com.um.app.mapper;

import com.um.app.persistence.domain.PermissionDomain;
import com.um.app.persistence.domain.RoleDomain;
import com.um.app.persistence.repository.PermissionRepository;
import com.um.app.service.PermissionService;
import com.um.app.service.RolesService;
import com.um.core.mapper.DtoMapper;
import com.um.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {PermissionMapper.class})
public interface RoleMapper extends DtoMapper<RolesService.RoleResponse, RoleDomain>, EntityMapper<RolesService.RoleRequest, RoleDomain> {


    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "permissions", source = "permissions", qualifiedByName = "fromId")
    RoleDomain toEntity(RolesService.RoleRequest request);

    @Mapping(target = "permissions", source = "permissions", qualifiedByName = "toId")
    RolesService.RoleResponse toResponse(RoleDomain entity);


    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "permissions", source = "permissions", qualifiedByName = "fromId")
    void updateDomain(@MappingTarget RoleDomain target, RolesService.RoleRequest source);
}
