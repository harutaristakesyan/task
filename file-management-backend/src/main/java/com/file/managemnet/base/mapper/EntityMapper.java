package com.file.managemnet.base.mapper;


import com.file.managemnet.base.entities.BaseEntity;
import org.mapstruct.Mapping;

public interface EntityMapper<R, E extends BaseEntity> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    E toEntity(R request);

}
