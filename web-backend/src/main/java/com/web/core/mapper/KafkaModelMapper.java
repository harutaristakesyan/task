package com.web.core.mapper;

import org.mapstruct.Mapping;

public interface KafkaModelMapper<K, E> {

    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    E fromKafkaModel(K entity);

}
