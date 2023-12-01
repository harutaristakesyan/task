package com.i18n.base.mapper;

public interface DtoMapper<R, E> {

    R toResponse(E entity);

}