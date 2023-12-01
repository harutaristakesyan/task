package com.configuration.core.mapper;

import org.mapstruct.Mapping;

public interface KafkaModelMapper<K, E> {

    @Mapping(target = "operationType", ignore = true)
    K toKafkaModel(E entity);

}
