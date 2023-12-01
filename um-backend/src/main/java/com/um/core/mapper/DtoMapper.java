package com.um.core.mapper;

public interface DtoMapper<R, E> {
    R toResponse(E entity);

}