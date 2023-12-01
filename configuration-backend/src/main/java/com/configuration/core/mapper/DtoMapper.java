package com.configuration.core.mapper;

public interface DtoMapper<R, E> {

    R toResponse(E entity);

}