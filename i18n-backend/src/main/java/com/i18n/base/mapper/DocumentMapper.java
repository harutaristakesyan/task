package com.i18n.base.mapper;


public interface DocumentMapper<R, E> {

    E toDocument(R request);
}
