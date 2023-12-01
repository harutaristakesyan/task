package com.web.core.mapper;

import com.web.core.persistence.domain.BaseDomain;

public interface DtoMapper<R, E> {

    R toDto(E domain);

}