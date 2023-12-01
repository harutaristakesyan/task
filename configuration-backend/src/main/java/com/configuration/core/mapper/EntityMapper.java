package com.configuration.core.mapper;

import com.configuration.core.persistence.domain.BaseDomain;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

public interface EntityMapper<R, E extends BaseDomain> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    E toEntity(R request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    void updateDomain(@MappingTarget E target, R source);
}
