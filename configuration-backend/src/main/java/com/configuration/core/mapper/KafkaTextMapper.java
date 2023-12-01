package com.configuration.core.mapper;

import com.configuration.app.persistence.domain.TextDomain;
import kafka.models.base.KafkaTextModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KafkaTextMapper extends EntityMapper<KafkaTextModel, TextDomain>, DtoMapper<KafkaTextModel, TextDomain> {

}
