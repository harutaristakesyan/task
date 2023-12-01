package com.web.core.mapper;

import com.web.core.persistence.domain.BaseDomain;
import org.mapstruct.Mapping;

public interface DomainMapper<R, E extends BaseDomain> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    E toDomain(R request);

}
