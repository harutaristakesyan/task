package com.admin.core.mapper;

import com.admin.app.persistence.domain.FileDomain;
import kafka.models.base.KafkaFileModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KafkaFileModelMapper {

    @Mapping(target = "id", source = "originalId")
    KafkaFileModel toKafkaModel(FileDomain domain);
}
