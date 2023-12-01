package com.file.managemnet.base.mapper;

public interface DtoMapper<R, E> {
    R toResponse(E entity);

}